package com.ApiBackEnd.java.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Getter

@Table (name = "card")
public class CardModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;


    @Column (length = 16, unique = true, nullable = false)
    private String cardNumber;


    @Column (nullable = false)
    private String holderName;


    @Column (nullable = false)
    private LocalDate expiryDate;


    @Column (length = 3, nullable = false)
    private String cvv;


}
