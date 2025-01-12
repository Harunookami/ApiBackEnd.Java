package com.ApiBackEnd.java.Repository;

import com.ApiBackEnd.java.Model.CardModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<CardModel, Long> {
}
