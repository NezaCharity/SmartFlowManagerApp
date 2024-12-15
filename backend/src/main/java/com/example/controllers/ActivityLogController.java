package com.example.controllers;

import com.example.models.ActivityLog;
import com.example.services.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class ActivityLogController {

    private final ActivityLogService activityLogService;

    @Autowired
    public ActivityLogController(ActivityLogService activityLogService) {
        this.activityLogService = activityLogService;
    }

    /**
     * Get all activity logs.
     * @return List of activity logs
     */
    @GetMapping("/")
    public ResponseEntity<List<ActivityLog>> getAllLogs() {
        List<ActivityLog> logs = activityLogService.getAllLogs();
        return ResponseEntity.ok(logs);
    }

    /**
     * Create a new activity log.
     * @param log ActivityLog object
     * @return Success message
     */
    @PostMapping("/")
    public ResponseEntity<String> createLog(@RequestBody ActivityLog log) {
        activityLogService.createLog(log);
        return ResponseEntity.ok("Log created successfully");
    }
}
