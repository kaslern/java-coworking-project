package com.example.ffwork.domain.resource;

import com.example.ffwork.money.Money;

import java.util.Set;

public class Room extends Resource {

    private final int seats;
    private final Set<String> equipment;

    public Room(String name, Money customHourRate, int seats, Set<String> equipment) {
        super(name, customHourRate);
        if (seats <= 0) {
            throw new IllegalArgumentException("Room must have at least 1 seat");
        }
        if (equipment == null) {
            throw new IllegalArgumentException("Equipment cannot be null");
        }
        this.seats = seats;
        this.equipment = equipment;
    }

    public int getSeats() {
        return seats;
    }

    public Set<String> getEquipment() {
        return equipment;
    }

    @Override
    protected Money baseRatePerHour() {
        return Money.of("100");
    }

    @Override
    public String describe() {
        return "Room: " + getName() + " seats=" + seats + " equipment=" + equipment;
    }
}
