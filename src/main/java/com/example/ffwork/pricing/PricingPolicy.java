package com.example.ffwork.pricing;

import com.example.ffwork.domain.booking.Booking;
import com.example.ffwork.money.Money;

public interface PricingPolicy {

    Money price(Booking booking);
}
