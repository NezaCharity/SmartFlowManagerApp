package com.example.controllers;

import com.example.models.Donation;
import com.example.services.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

@Controller
@RequestMapping("/donations")
public class DonationController {

    @Autowired
    private DonationService donationService;

    // Add Donation Page
    @GetMapping("/add")
    public String showAddDonationPage() {
        return "add-donation";
    }

    @PostMapping("/add")
    public String addDonation(@RequestParam int donorId,
                              @RequestParam double amount,
                              @RequestParam String donationMessage) {
        Donation donation = new Donation();
        donation.setDonorId(donorId);
        donation.setAmount(amount);
        donation.setDonationDate(new Timestamp(new Date().getTime()));
        //donation.setDonationMessage(donationMessage); // Handle the message

        donationService.createDonation(donation);
        return "redirect:/donations/view";
    }

    // View Donations Page
    @GetMapping("/view")
    public String viewDonations(Model model) {
        model.addAttribute("donations", donationService.getAllDonations());
        return "view-donations";
    }

    // Donation Detail Page
    @GetMapping("/detail/{id}")
    public String viewDonationDetail(@PathVariable int id, Model model) {
        Donation donation = donationService.getAllDonations().stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
        model.addAttribute("donation", donation);
        return "donation-detail";
    }
}
