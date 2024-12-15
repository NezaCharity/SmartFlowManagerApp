package com.example.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.models.*;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "admin-dashboard"; // Maps to admin-dashboard.jsp
    }

    @GetMapping("/manage-users")
    public String manageUsers() {
        return "admin-manage-users"; // Create this JSP for user management
    }

    @GetMapping("/donations")
    public String viewDonations() {
        return "admin-view-donations"; // Create this JSP for viewing donations
    }
}
