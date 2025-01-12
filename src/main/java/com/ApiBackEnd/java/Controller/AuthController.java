package com.ApiBackEnd.java.Controller;

import com.ApiBackEnd.java.Model.AuthenticationModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @PostMapping (value = "/login")
    public ResponseEntity <?> login(@RequestBody AuthenticationModel userAuth) {

    }
}
