package com.example.repositories;

import com.example.models.ActivityLog;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ActivityLogRepository {

    private final JdbcTemplate jdbcTemplate;

    public ActivityLogRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper to map ResultSet to ActivityLog object
    private final RowMapper<ActivityLog> activityLogRowMapper = (rs, rowNum) -> {
        ActivityLog activityLog = new ActivityLog();
        activityLog.setId(rs.getInt("id"));
        activityLog.setUserId(rs.getInt("user_id"));
        activityLog.setActivityType(rs.getString("activity_type"));
        activityLog.setActivityDescription(rs.getString("activity_description"));
        activityLog.setActivityTimestamp(rs.getTimestamp("activity_timestamp"));
        return activityLog;
    };

    // Fetch all activity logs
    public List<ActivityLog> getAllActivityLogs() {
        String sql = "SELECT * FROM activity_logs";
        return jdbcTemplate.query(sql, activityLogRowMapper);
    }

    // Fetch activity log by ID
    public ActivityLog getActivityLogById(int id) {
        String sql = "SELECT * FROM activity_logs WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, activityLogRowMapper);
    }

    // Fetch activity logs by user ID
    public List<ActivityLog> getActivityLogsByUserId(int userId) {
        String sql = "SELECT * FROM activity_logs WHERE user_id = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, activityLogRowMapper);
    }

    // Add a new activity log
    public void createActivityLog(ActivityLog activityLog) {
        String sql = "INSERT INTO activity_logs (user_id, activity_type, activity_description, activity_timestamp) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                activityLog.getUserId(),
                activityLog.getActivityType(),
                activityLog.getActivityDescription(),
                activityLog.getActivityTimestamp());
    }

    // Update an existing activity log
    public void updateActivityLog(ActivityLog activityLog) {
        String sql = "UPDATE activity_logs SET user_id = ?, activity_type = ?, activity_description = ?, activity_timestamp = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                activityLog.getUserId(),
                activityLog.getActivityType(),
                activityLog.getActivityDescription(),
                activityLog.getActivityTimestamp(),
                activityLog.getId());
    }

    // Delete an activity log by ID
    public void deleteActivityLog(int id) {
        String sql = "DELETE FROM activity_logs WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
    
}
