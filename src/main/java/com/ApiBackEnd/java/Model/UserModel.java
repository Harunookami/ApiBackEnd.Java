package com.ApiBackEnd.java.Model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name  = "users")
public class UserModel {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long Id;

    @Column (length = 50, unique = true, nullable = false)
    private String email;

    @Column (length = 10, nullable = false)
    private String password;


}
