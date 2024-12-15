package com.example.controllers;

import com.example.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        // Get the current logged-in user
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        // Add user details to the model to display on the dashboard
        model.addAttribute("user", loggedInUser);
        
        // Return the name of the dashboard view (dashboard.jsp)
        return "dashboard"; 
    }
}
