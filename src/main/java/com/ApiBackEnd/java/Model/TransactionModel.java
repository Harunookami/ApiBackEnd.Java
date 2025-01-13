package com.ApiBackEnd.java.Model;

import com.ApiBackEnd.java.Enum.TransactionType;
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

    @Column(nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(length = 100, nullable = false)
    private TransactionType type;

    @Column (length = 250)
    private String description;

    @Column (nullable = false)
    private LocalDate date;
}
