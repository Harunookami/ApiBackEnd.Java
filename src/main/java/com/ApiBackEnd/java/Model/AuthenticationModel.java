package com.ApiBackEnd.java.Model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AuthenticationModel {

    @NotNull
    private String username;
    @NotNull
    private String password;

}
