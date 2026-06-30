package com.example.ffwork.payment;

import com.example.ffwork.money.Money;

public class CardPayment extends Payment{

    String last4Digit;

    public CardPayment(Money amount, String paymentId, String last4Digit) {
        super(amount, paymentId);
        this.last4Digit = last4Digit;
    }

    @Override
    public void capture() {
        setStatus(PaymentStatus.CAPTURED);
    }
}
