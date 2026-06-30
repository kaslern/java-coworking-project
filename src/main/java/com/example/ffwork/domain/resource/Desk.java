package com.example.ffwork.domain.resource;

import com.example.ffwork.money.Money;

public class Desk extends Resource{

    private final DeskType type;

    public Desk(String name, Money customHourRate, DeskType type) {
        super(name, customHourRate);
        if (type == null) {
            throw new IllegalArgumentException("Name or type cannot be null");
        }
        this.type = type;
    }

    public DeskType getType() {
        return type;
    }

    @Override
    protected Money baseRatePerHour() {
        return Money.of("50");
    }

    @Override
    public String describe() {
        return "Desk: " + getName() + " Type: " + getType();
    }
}
