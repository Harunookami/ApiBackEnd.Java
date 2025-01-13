package com.ApiBackEnd.java.Model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

public class AuthenticationModel {

    @NotNull
    private String username;
    @NotNull
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


}
