package com.ApiBackEnd.java.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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


    @Column ( unique = true, nullable = false)
    @Size(min = 16, max = 16, message = "Card number must be 16 digits")
    private String cardNumber;


    @Column (nullable = false)
    private String holderName;


    @Column (nullable = false)
    private LocalDate expiryDate;


    @Column (unique = true, nullable = false)
    @Size (min = 3, max = 3)
    private String cvv;


}
