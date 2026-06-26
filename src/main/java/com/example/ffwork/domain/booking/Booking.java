package com.example.ffwork.domain.booking;

import com.example.ffwork.domain.resource.Resource;
import com.example.ffwork.domain.user.User;
import com.example.ffwork.money.Money;

import java.time.LocalDateTime;

public class Booking {

    private String id;
    private final User user;
    private final Resource resource;
    private final LocalDateTime start;
    private final LocalDateTime end;
    private BookingStatus status;
    private Money calculatedPrice;
    //private Payment payment;


    public Booking(User user, Resource resource, LocalDateTime start,
                   LocalDateTime end, Money calculatedPrice) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        if (resource == null) {
            throw new IllegalArgumentException("Resource cannot be null");
        }
        if (start == null) {
            throw new IllegalArgumentException("Start time cannot be null");
        }
        if (end == null) {
            throw new IllegalArgumentException("End time cannot be null");
        }
        if (!end.isAfter(start)) {
            throw new IllegalArgumentException("End must be after start");
        }
        if (calculatedPrice == null) {
            throw new IllegalArgumentException("Price cannot be null");
        }
        this.user = user;
        this.resource = resource;
        this.start = start;
        this.end = end;
        this.status = BookingStatus.PENDING;
        this.calculatedPrice = calculatedPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public Resource getResource() {
        return resource;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public Money getCalculatedPrice() {
        return calculatedPrice;
    }

    public void setCalculatedPrice(Money calculatedPrice) {
        this.calculatedPrice = calculatedPrice;
    }

    public void confirm() {
        if (this.status != BookingStatus.PENDING) {
            throw new IllegalStateException
                    ("Cannot confirm booking in status: " + this.status);
        }
        this.status = BookingStatus.CONFIRMED;
    }

    public void cancel() {
        if (this.status != BookingStatus.PENDING && this.status != BookingStatus.CONFIRMED) {
            throw new IllegalStateException("Cannot cancel booking in status: " + this.status);
        }
        this.status = BookingStatus.CANCELLED;
    }

    public void complete() {
        if (this.status != BookingStatus.CONFIRMED) {
            throw new IllegalStateException
                    ("Cannot complete booking in status: " + this.status);
        }
        this.status = BookingStatus.COMPLETED;
    }

    public int durationMinutes() {
        return (int) java.time.Duration.between(start, end).toMinutes();
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", resource=" + resource +
                ", start=" + start +
                ", end=" + end +
                ", status=" + status +
                ", calculatedPrice=" + calculatedPrice +
                '}';
    }
}
