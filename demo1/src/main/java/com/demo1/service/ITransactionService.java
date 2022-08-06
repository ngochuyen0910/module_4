package com.demo1.service;

import com.demo1.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface ITransactionService {
    List<Transaction> findAll();

    void save(Transaction Transaction);

    Optional<Transaction> findById(String transactionId);

    List<Transaction> findByNameContaining(String name, String transaction_type);

}
