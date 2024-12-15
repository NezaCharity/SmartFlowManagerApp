package com.example.services;

import com.example.models.Transaction;
import com.example.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    /**
     * Retrieves all transactions.
     * @return List of Transaction objects
     */
    public List<Transaction> getAllTransactions() {
        return transactionRepository.getAllTransactions();
    }

    /**
     * Creates a new transaction record.
     * @param transaction Transaction object
     */
    public void createTransaction(Transaction transaction) {
        transactionRepository.createTransaction(transaction);
    }
}
