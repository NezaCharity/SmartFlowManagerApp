package com.example.repositories;

import com.example.models.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionRepository {

    private final JdbcTemplate jdbcTemplate;

    public TransactionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper to map ResultSet to Transaction object
    private final RowMapper<Transaction> transactionRowMapper = (rs, rowNum) -> {
        Transaction transaction = new Transaction();
        transaction.setId(rs.getInt("id"));
        transaction.setDonationId(rs.getInt("donation_id"));
        transaction.setPaymentMethod(rs.getString("payment_method"));
        transaction.setTransactionStatus(rs.getString("transaction_status"));
        transaction.setTransactionId(rs.getString("transaction_id"));
        transaction.setTransactionDate(rs.getTimestamp("transaction_date"));
        return transaction;
    };

    // Fetch all transactions
    public List<Transaction> getAllTransactions() {
        String sql = "SELECT * FROM transactions";
        return jdbcTemplate.query(sql, transactionRowMapper);
    }

    // Fetch transaction by ID
    public Transaction getTransactionById(int id) {
        String sql = "SELECT * FROM transactions WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, transactionRowMapper);
    }

    // Fetch transactions by donation ID
    public List<Transaction> getTransactionsByDonationId(int donationId) {
        String sql = "SELECT * FROM transactions WHERE donation_id = ?";
        return jdbcTemplate.query(sql, new Object[]{donationId}, transactionRowMapper);
    }

    // Add a new transaction
    public void createTransaction(Transaction transaction) {
        String sql = "INSERT INTO transactions (donation_id, payment_method, transaction_status, transaction_id, transaction_date) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                transaction.getDonationId(),
                transaction.getPaymentMethod(),
                transaction.getTransactionStatus(),
                transaction.getTransactionId(),
                transaction.getTransactionDate());
    }

    // Update an existing transaction
    public void updateTransaction(Transaction transaction) {
        String sql = "UPDATE transactions SET donation_id = ?, payment_method = ?, transaction_status = ?, transaction_id = ?, transaction_date = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                transaction.getDonationId(),
                transaction.getPaymentMethod(),
                transaction.getTransactionStatus(),
                transaction.getTransactionId(),
                transaction.getTransactionDate(),
                transaction.getId());
    }

    // Delete a transaction by ID
    public void deleteTransaction(int id) {
        String sql = "DELETE FROM transactions WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
