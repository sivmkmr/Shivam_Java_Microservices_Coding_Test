package com.shivam.ordermanagement.exception;

import com.shivam.ordermanagement.model.OrderStatus;

public class InvalidStatusTransitionException extends RuntimeException {

    public InvalidStatusTransitionException(OrderStatus current, OrderStatus target) {
        super("Invalid status transition from " + current + " to " + target);
    }
}
