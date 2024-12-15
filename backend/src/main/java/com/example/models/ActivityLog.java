package com.example.models;

import java.sql.Timestamp;

public class ActivityLog {
    private int id;
    private int userId;
    private String activityType;
    private String activityDescription;
    private Timestamp activityTimestamp;

    // Default constructor
    public ActivityLog() {
    }

    // Constructor with parameters
    public ActivityLog(int id, int userId, String activityType, String activityDescription, Timestamp activityTimestamp) {
        this.id = id;
        this.userId = userId;
        this.activityType = activityType;
        this.activityDescription = activityDescription;
        this.activityTimestamp = activityTimestamp;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    public Timestamp getActivityTimestamp() {
        return activityTimestamp;
    }

    public void setActivityTimestamp(Timestamp activityTimestamp) {
        this.activityTimestamp = activityTimestamp;
    }
}
