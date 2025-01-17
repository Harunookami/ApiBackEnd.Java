package com.ApiBackEnd.java.Service;

import com.ApiBackEnd.java.Model.LoginRequest;
import com.ApiBackEnd.java.Model.UserModel;
import com.ApiBackEnd.java.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserModel addUser(UserModel user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }


    public List<UserModel> listAllUsers() {
        return userRepository.findAll();
    }

    public UserDetailsImpl authenticate(LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return userDetails;
    }

    public UserModel updateUser (Long id, UserModel userModel) {
        return userRepository.save(userModel);
    }

    public boolean deleteUser(Long id) {
        UserModel user = userRepository.findById(id).get();
        userRepository.delete(user);
        return true;
    }


}
