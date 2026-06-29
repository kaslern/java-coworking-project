package com.example.ffwork.billing;

import com.example.ffwork.domain.booking.Booking;

public interface Billable {

    Invoice toInvoice(Booking booking);
}
