package com.demo1.service;

import com.demo1.model.Transaction;
import com.demo1.repository.ITransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService implements ITransactionService {
    @Autowired
    private ITransactionRepository transactionRepository;

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public Optional<Transaction> findById(String transactionId) {
        return transactionRepository.findById(transactionId);
    }

    @Override
    public List<Transaction> findByNameContaining(String name, String transaction_type) {
        if(!transaction_type.equals("")){
            return transactionRepository.findByNameContaining("%" + name + "%",transaction_type);
        }
        return transactionRepository.findByNameContaining("%" + name + "%", "%" + transaction_type + "%");
    }
}
