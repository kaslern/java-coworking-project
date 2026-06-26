package com.example.ffwork.pricing;

import com.example.ffwork.domain.booking.Booking;
import com.example.ffwork.money.Money;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HappyHoursPricing implements PricingPolicy {

    private static final BigDecimal DISCOUNT_RATE = new BigDecimal("0.30");
    private static final BigDecimal MINUTES_PER_HOUR = BigDecimal.valueOf(60);

    @Override
    public Money price(Booking booking) {
        int minutes = booking.durationMinutes();
        Money hourlyRate = booking.getResource().hourlyRate();
        BigDecimal minutesAsBigDecimal = BigDecimal.valueOf(minutes);
        BigDecimal hoursMultiplier = minutesAsBigDecimal.divide(MINUTES_PER_HOUR, 2, RoundingMode.HALF_UP);
        Money standardPrice = hourlyRate.multiply(hoursMultiplier);
        int startHour = booking.getStart().getHour();

        if (startHour >= 14 && startHour < 16) {
            Money discount = standardPrice.multiply(DISCOUNT_RATE);
            return standardPrice.subtract(discount);
        } else
            return standardPrice;
    }


}
