package com.example.services;

import com.example.models.Donation;
import com.example.repositories.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationService {

    private final DonationRepository donationRepository;

    @Autowired
    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    /**
     * Retrieves all donations.
     * @return List of Donation objects
     */
    public List<Donation> getAllDonations() {
        return donationRepository.getAllDonations();
    }

    /**
     * Retrieves donations by donor ID.
     * @param donorId Donor's ID
     * @return List of Donation objects for the donor
     */
    public List<Donation> getDonationsByDonor(int donorId) {
        return donationRepository.getDonationsByDonorId(donorId);
    }

    /**
     * Creates a new donation record.
     * @param donation Donation object
     */
    public void createDonation(Donation donation) {
        donationRepository.createDonation(donation);
    }
}
