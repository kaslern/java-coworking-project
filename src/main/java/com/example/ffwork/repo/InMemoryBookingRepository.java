package com.example.ffwork.repo;

import com.example.ffwork.domain.booking.Booking;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryBookingRepository implements BookingRepository {

    private final List<Booking> bookingDataBase = new ArrayList<>();

    @Override
    public void add(Booking booking) {

        Optional<Booking> existingId = findById(booking.getId());

        if (existingId.isPresent()) {
            throw new IllegalArgumentException("Booking with such ID already exist");
        }

        bookingDataBase.add(booking);
    }

    @Override
    public Optional<Booking> findById(String id) {
        for (Booking booking : bookingDataBase) {
            if (booking.getId().equals(id)) {
                return Optional.of(booking);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Booking> findAll() {
        return new ArrayList<>(bookingDataBase);
    }
}
