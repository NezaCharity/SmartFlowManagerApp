package com.example.services;

import com.example.models.ActivityLog;
import com.example.repositories.ActivityLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class ActivityLogService {

    private final ActivityLogRepository activityLogRepository;

    @Autowired
    public ActivityLogService(ActivityLogRepository activityLogRepository) {
        this.activityLogRepository = activityLogRepository;
    }

    /**
     * Retrieves all activity logs.
     * @return List of ActivityLog objects
     */
    public List<ActivityLog> getAllLogs() {
        return activityLogRepository.getAllActivityLogs(); // Updated method name
    }

    /**
     * Creates a new activity log record.
     * @param log ActivityLog object
     */
    public void createLog(ActivityLog log) {
        activityLogRepository.createActivityLog(log); // Updated method name
    }
}
