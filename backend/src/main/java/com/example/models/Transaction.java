package com.example.models;

import java.sql.Timestamp;

public class Transaction {
    private int id;
    private int donationId;
    private String paymentMethod;
    private String transactionStatus;
    private String transactionId;
    private Timestamp transactionDate;

    // Default constructor
    public Transaction() {
    }

    // Constructor with parameters
    public Transaction(int id, int donationId, String paymentMethod, String transactionStatus, String transactionId, Timestamp transactionDate) {
        this.id = id;
        this.donationId = donationId;
        this.paymentMethod = paymentMethod;
        this.transactionStatus = transactionStatus;
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDonationId() {
        return donationId;
    }

    public void setDonationId(int donationId) {
        this.donationId = donationId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }
}
