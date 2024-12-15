package com.example.models;

import java.sql.Timestamp;

public class Donation {
    private int id;
    private int donorId;
    private double amount;
    private Timestamp donationDate;

    // Default constructor
    public Donation() {
    }

    // Constructor with parameters
    public Donation(int id, int donorId, double amount, Timestamp donationDate) {
        this.id = id;
        this.donorId = donorId;
        this.amount = amount;
        this.donationDate = donationDate;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDonorId() {
        return donorId;
    }

    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Timestamp getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(Timestamp donationDate) {
        this.donationDate = donationDate;
    }
}
