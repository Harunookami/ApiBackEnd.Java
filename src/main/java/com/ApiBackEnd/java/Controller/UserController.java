package com.ApiBackEnd.java.Controller;

import com.ApiBackEnd.java.Model.UserModel;
import com.ApiBackEnd.java.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserModel addUser(@RequestBody UserModel user) {
        return userService.addUser(user);
    }

    @GetMapping
    public List<UserModel> getAllUsers() {
        return userService.listAllUsers();
    }

    @PutMapping()
    public UserService updateUser ( @RequestBody UserModel userModel) {
        return userService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") Long id) {
        boolean deleted = userService.deleteUser(id);

        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
