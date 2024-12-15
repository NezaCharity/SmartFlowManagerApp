package com.example.repositories;

import com.example.models.Donation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DonationRepository {

    private final JdbcTemplate jdbcTemplate;

    public DonationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper for mapping ResultSet to Donation object
    private RowMapper<Donation> donationRowMapper = (rs, rowNum) -> {
        Donation donation = new Donation();
        donation.setId(rs.getInt("id"));
        donation.setDonorId(rs.getInt("donor_id"));
        donation.setAmount(rs.getDouble("amount"));
        donation.setDonationDate(rs.getTimestamp("donation_date"));
        return donation;
    };

    // Get all donations
    public List<Donation> getAllDonations() {
        String sql = "SELECT * FROM donations";
        return jdbcTemplate.query(sql, donationRowMapper);
    }

    // Get donations by donor ID
    public List<Donation> getDonationsByDonorId(int donorId) {
        String sql = "SELECT * FROM donations WHERE donor_id = ?";
        return jdbcTemplate.query(sql, new Object[]{donorId}, donationRowMapper);
    }

    // Create a donation
    public void createDonation(Donation donation) {
        String sql = "INSERT INTO donations (donor_id, amount, donation_date) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, donation.getDonorId(), donation.getAmount(), donation.getDonationDate());
    }
}
