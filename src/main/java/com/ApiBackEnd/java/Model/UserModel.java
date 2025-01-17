package com.ApiBackEnd.java.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.User;

@Data
@Entity
@NoArgsConstructor
@Table(name  = "users")
public class UserModel {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Email
    @Column (length = 50, unique = true, nullable = false)
    private String email;


    @Column (length = 60, nullable = false)
    @NotNull(message = "Password cannot be null")
    private String password;


}
