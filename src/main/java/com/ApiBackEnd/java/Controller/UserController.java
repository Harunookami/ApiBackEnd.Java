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

    @PostMapping("/users/register")
    public ResponseEntity<UserModel> addUser(@RequestBody UserModel user) {
        UserModel createdUser = userService.addUser(user);
        return ResponseEntity.status(201).body(createdUser);
    }

    @GetMapping
    public ResponseEntity <List<UserModel>> getAllUsers() {
        List<UserModel> users = userService.listAllUsers();
        return ResponseEntity.ok().body(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity <UserModel> updateUser (@PathVariable Long id, @RequestBody UserModel userModel) {
        UserModel updatedUser = userService.updateUser(id, userModel);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
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
