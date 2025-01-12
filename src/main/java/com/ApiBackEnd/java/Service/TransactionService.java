package com.ApiBackEnd.java.Service;


import com.ApiBackEnd.java.Model.TransactionModel;
import com.ApiBackEnd.java.Repository.TransactionRepository;
import jakarta.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionService (TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public TransactionModel addTransaction(TransactionModel transactionModel) {
        return transactionRepository.save(transactionModel);
    }

    public List<TransactionModel> getTransactions() {
        return transactionRepository.findAll();
    }
}
