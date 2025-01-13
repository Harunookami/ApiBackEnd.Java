package com.ApiBackEnd.java.Model;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
public class AccessModel {


    @NotNull (message = "Token cannot be null")
    private String token;

    public AccessModel(String token) {
        this.token = token;
    }

}
