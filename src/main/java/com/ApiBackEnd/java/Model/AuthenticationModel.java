package com.ApiBackEnd.java.Model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AuthenticationModel {


    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;
}
