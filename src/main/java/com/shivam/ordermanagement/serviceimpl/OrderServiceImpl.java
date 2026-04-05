package com.shivam.ordermanagement.serviceimpl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.shivam.ordermanagement.dto.CreateOrderRequest;
import com.shivam.ordermanagement.dto.OrderResponse;
import com.shivam.ordermanagement.exception.InvalidStatusTransitionException;
import com.shivam.ordermanagement.exception.OrderNotFoundException;
import com.shivam.ordermanagement.model.Order;
import com.shivam.ordermanagement.model.OrderStatus;
import com.shivam.ordermanagement.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    private final Map<String, Order> orderStore = new ConcurrentHashMap<>();

    public OrderResponse createOrder(CreateOrderRequest request) {
        Order order = new Order(request.getCustomerName(), request.getAmount());
        orderStore.put(order.getOrderId(), order);
        return OrderResponse.from(order);
    }

    public OrderResponse getOrderById(String orderId) {
        Order order = findOrThrow(orderId);
        return OrderResponse.from(order);
    }

    public OrderResponse updateOrderStatus(String orderId, OrderStatus newStatus) {
        Order order = findOrThrow(orderId);
        if (!order.getStatus().canTransitionTo(newStatus)) {
            throw new InvalidStatusTransitionException(order.getStatus(), newStatus);
        }
        order.setStatus(newStatus);
        return OrderResponse.from(order);
    }

    public List<OrderResponse> getAllOrders() {
        return orderStore.values().stream()
                .map(OrderResponse::from)
                .collect(Collectors.toList());
    }

    private Order findOrThrow(String orderId) {
        Order order = orderStore.get(orderId);
        if (order == null) {
            throw new OrderNotFoundException(orderId);
        }
        return order;
    }
}
