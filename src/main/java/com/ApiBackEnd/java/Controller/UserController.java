package com.ApiBackEnd.java.Controller;

import com.ApiBackEnd.java.Model.UserModel;
import com.ApiBackEnd.java.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserService addUser(@RequestBody UserModel user) {
        return userService = userService;
    }
}
