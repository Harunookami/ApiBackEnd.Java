package com.ApiBackEnd.java.Controller;

import com.ApiBackEnd.java.Model.TransactionModel;
import com.ApiBackEnd.java.Service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity <TransactionModel> addTransaction(@Valid @RequestBody  TransactionModel transaction) {
        TransactionModel createdTransaction = transactionService.addTransaction(transaction);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTransaction);
    }

    @GetMapping()
    public ResponseEntity<List<TransactionModel>> getTransactions() {
        List<TransactionModel> transactions = transactionService.getTransactions();
        return ResponseEntity.ok(transactions);
    }

}
