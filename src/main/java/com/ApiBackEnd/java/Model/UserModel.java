package com.ApiBackEnd.java.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String login;


    @Column (length = 60, nullable = false)
    private String password;


    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


}
