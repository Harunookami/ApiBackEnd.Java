package com.ApiBackEnd.java.Model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private String Login;

    public Long getId() {
        return Id;
    }


    public String getEmail() {
        return email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
