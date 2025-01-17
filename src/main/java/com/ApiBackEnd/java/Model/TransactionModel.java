package com.ApiBackEnd.java.Model;

import com.ApiBackEnd.java.Enum.TransactionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotNull(message = "Transaction type cannot be null")
    private TransactionType type;

    @Column (length = 250)
    @Size(max = 250, message = "Description cannot be longer than 250 characters")
    private String description;

    @Column (nullable = false)
    private LocalDate date;
}
