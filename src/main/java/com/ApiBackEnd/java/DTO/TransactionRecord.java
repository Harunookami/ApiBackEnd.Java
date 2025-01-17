package com.ApiBackEnd.java.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransactionRecord(BigDecimal amount, String type, LocalDate date) {
}
