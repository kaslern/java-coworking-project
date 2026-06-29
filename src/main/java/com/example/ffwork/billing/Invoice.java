package com.example.ffwork.billing;

import com.example.ffwork.domain.user.User;
import com.example.ffwork.money.Money;

import java.time.LocalDateTime;

public class Invoice {

    private final String invoiceNumber;
    private final LocalDateTime issueDate;
    private final User buyer;
    private final Money total;
    private final String itemDescription;

    public Invoice(String invoiceNumber, LocalDateTime issueDate, User buyer, Money total, String itemDescription) {
        this.invoiceNumber = invoiceNumber;
        this.issueDate = issueDate;
        this.buyer = buyer;
        this.total = total;
        this.itemDescription = itemDescription;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public User getBuyer() {
        return buyer;
    }

    public Money getTotal() {
        return total;
    }

    public String getItemDescription() {
        return itemDescription;
    }
}
