package com.ApiBackEnd.java.Model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "transaction")
public class TransactionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @ManyToOne
    @JoinColumn (name = "user_id", nullable = false)
    private UserModel user;

    private BigDecimal amount;

    @Column(length = 100, nullable = false)
    private String type;

    @Column (length = 250)
    private String description;

    @Column (length = 50, nullable = false)
    private LocalDate date;
}
