package com.ApiBackEnd.java.Repository;

import com.ApiBackEnd.java.Model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionModel, Long> {
}
