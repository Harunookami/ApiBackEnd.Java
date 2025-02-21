package com.ApiBackEnd.java.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
public class AuthenticationModel {

    @Getter
    private Collection<GrantedAuthority> authorities;

    @Getter
    @NotNull ( message = "Username cannot be null")
    @Email(message = "Invalid email format")
    private String email;

    @Getter
    @NotEmpty(message = "Password cannot be empty")
    private String password;


}
