package com.ApiBackEnd.java.Service;

import com.ApiBackEnd.java.Model.UserModel;
import com.ApiBackEnd.java.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserModel addUser(UserModel user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void newUser(UserModel user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public List<UserModel> listAllUsers() {
        return userRepository.findAll();
    }

    public UserModel updateUser (Long id, UserModel userModel) {
        return userRepository.save(userModel);
    }

    public boolean deleteUser(Long id) {
        UserModel user = userRepository.findById(id).get();
        userRepository.delete(user);
        return false;
    }

}
