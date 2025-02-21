package com.ApiBackEnd.java.Controller;

import com.ApiBackEnd.java.Model.AccessModel;
import com.ApiBackEnd.java.Model.AuthenticationModel;
import com.ApiBackEnd.java.Service.AuthService;
import com.ApiBackEnd.java.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private UserService userService;

    @PostMapping ("/login")
    public ResponseEntity <AccessModel> login( @Valid  @RequestBody AuthenticationModel userAuth) {
        AccessModel accessModel = authService.login(userAuth).getBody();
        if (accessModel != null) {
            return ResponseEntity.ok(accessModel);
        } else {
            return ResponseEntity.status(401).body(new AccessModel("Access Denied"));
        }
    }


}
