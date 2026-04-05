package com.shivam.ordermanagement.model;

public enum OrderStatus {
    NEW,
    PROCESSING,
    COMPLETED;

    public OrderStatus next() {
        return switch (this) {
            case NEW -> PROCESSING;
            case PROCESSING -> COMPLETED;
            case COMPLETED -> throw new IllegalStateException("Order is already COMPLETED and cannot be advanced further.");
        };
    }

    public boolean canTransitionTo(OrderStatus target) {
        return switch (this) {
            case NEW -> target == PROCESSING;
            case PROCESSING -> target == COMPLETED;
            case COMPLETED -> false;
        };
    }
}
