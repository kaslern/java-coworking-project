package com.example.ffwork.domain.resource;

import com.example.ffwork.money.Money;

public class Device extends Resource{

    private final int quantity;

    public Device(String name, Money customHourRate, int quantity) {
        super(name, customHourRate);
        if (quantity <= 0) {
            throw new IllegalArgumentException("Device quantity is at least 1");
        }
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    protected Money baseRatePerHour() {
        return Money.of("20");
    }

    @Override
    public String describe() {
        return "Device: " + getName() + " Quantity: " + getQuantity();
    }
}
