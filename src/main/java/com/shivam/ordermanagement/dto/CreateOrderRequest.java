package com.shivam.ordermanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class CreateOrderRequest {

    @NotBlank(message = "customerName is mandatory")
    private String customerName;

    @Positive(message = "amount must be greater than 0")
    private Double amount;

    public CreateOrderRequest() {}

    public CreateOrderRequest(String customerName, Double amount) {
        this.customerName = customerName;
        this.amount = amount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
