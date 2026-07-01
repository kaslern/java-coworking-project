package com.example.ffwork.repo;


import com.example.ffwork.domain.booking.Booking;

import java.util.List;
import java.util.Optional;

interface BookingRepository {
    void add(Booking booking);

    Optional<Booking> findById(String id);

    List<Booking> findAll();
}