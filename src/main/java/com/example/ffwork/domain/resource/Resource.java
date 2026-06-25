package com.example.ffwork.domain.resource;

import com.example.ffwork.money.Money;

public abstract class Resource {
    private final String name;
    private final Money customHourlyRate;

    public Resource(String name, Money customHourRate) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
        this.customHourlyRate = customHourRate;
    }

    public String getName() {
        return name;
    }

    public Money getCustomHourlyRate() {
        return customHourlyRate;
    }

    protected abstract Money baseRatePerHour();

    public abstract String describe();

    public Money hourlyRate() {
        if (customHourlyRate != null) {
            return customHourlyRate;
        }
        return baseRatePerHour();

    }


}
