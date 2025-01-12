package com.ApiBackEnd.java.Controller;

import com.ApiBackEnd.java.Model.TransactionModel;
import com.ApiBackEnd.java.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public TransactionModel addTransaction(@RequestBody  TransactionModel transaction) {
        return transactionService.addTransaction(transaction);
    }

    @GetMapping("/transactions")
    public List<TransactionModel> getTransactions() {
        return transactionService.getTransactions();
    }

}
