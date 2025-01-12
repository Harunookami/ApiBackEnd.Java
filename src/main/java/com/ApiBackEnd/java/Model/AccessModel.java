package com.ApiBackEnd.java.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
public class AccessModel {


    @NotNull
    private String token;

    public AccessModel(String token) {
        this.token = token;
    }

}
