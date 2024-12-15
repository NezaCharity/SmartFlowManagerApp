package com.example.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.models.*;

@Controller
@RequestMapping("/staff")
public class StaffController {

    @GetMapping("/dashboard")
    public String staffDashboard() {
        return "staff-dashboard"; // Maps to staff-dashboard.jsp
    }

    @GetMapping("/activity-logs")
    public String viewActivityLogs() {
        return "staff-activity-logs"; // Create this JSP for viewing logs
    }

    @GetMapping("/reports")
    public String viewReports() {
        return "staff-view-reports"; // Create this JSP for viewing reports
    }
}
