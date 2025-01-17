package com.ApiBackEnd.java.Service;


import com.ApiBackEnd.java.Model.TransactionModel;
import com.ApiBackEnd.java.Model.UserModel;
import com.ApiBackEnd.java.Repository.TransactionRepository;
import com.ApiBackEnd.java.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    public TransactionService (TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public TransactionModel addTransaction(TransactionModel transactionModel) {
        Optional<UserModel> user = userRepository.findByEmail(transactionModel.getUser().getEmail());
        if(user.isPresent()){
            transactionModel.setUser(user.get());
            return transactionRepository.save(transactionModel);
        }
        throw new RuntimeException("User not found");
    }

    public List<TransactionModel> getTransactions() {
        return transactionRepository.findAll();
    }
}
