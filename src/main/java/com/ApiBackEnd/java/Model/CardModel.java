package com.ApiBackEnd.java.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table (name = "card")
public class CardModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    @Column (unique = true, nullable = false)
    private String cardNumber;


    @Column (nullable = false)
    private String holderName;

    @Column (nullable = false)
    private String expiryDate;

    @Column ( nullable = false)
    private String cvv;

}
