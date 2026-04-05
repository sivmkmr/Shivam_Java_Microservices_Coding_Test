package com.shivam.ordermanagement.service;

import java.util.List;

import com.shivam.ordermanagement.dto.CreateOrderRequest;
import com.shivam.ordermanagement.dto.OrderResponse;
import com.shivam.ordermanagement.model.OrderStatus;

public interface OrderService {

    OrderResponse createOrder(CreateOrderRequest request);

    OrderResponse getOrderById(String orderId);

    OrderResponse updateOrderStatus(String orderId, OrderStatus newStatus);

    List<OrderResponse> getAllOrders();
}
