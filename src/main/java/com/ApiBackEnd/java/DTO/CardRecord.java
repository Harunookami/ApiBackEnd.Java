package com.ApiBackEnd.java.DTO;

import java.time.LocalDate;

public record CardRecord(String cardNumber, LocalDate expiryDate, String cvv, String holderName ) {
}
