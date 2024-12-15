package com.example.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.models.*;


@Controller
@RequestMapping("/donor")
public class DonorController {

    @GetMapping("/home")
    public String donorHome() {
        return "donor-home"; // Maps to donor-home.jsp
    }

    @GetMapping("/donations")
    public String viewDonations() {
        return "donor-view-donations"; // Create this JSP for viewing their donations
    }

    @GetMapping("/add-donation")
    public String addDonation() {
        return "donor-add-donation"; // Create this JSP for adding donations
    }
}
