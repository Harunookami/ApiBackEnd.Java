package com.ApiBackEnd.java.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class AccessModel {


    @NotNull
    private String token;

}
