package com.example.controllers;

import com.example.models.Transaction;
import com.example.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    /**
     * Get all transactions.
     * @return List of transactions
     */
    @GetMapping("/")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    /**
     * Create a new transaction.
     * @param transaction Transaction object
     * @return Success message
     */
    @PostMapping("/")
    public ResponseEntity<String> createTransaction(@RequestBody Transaction transaction) {
        transactionService.createTransaction(transaction);
        return ResponseEntity.ok("Transaction created successfully");
    }
}
