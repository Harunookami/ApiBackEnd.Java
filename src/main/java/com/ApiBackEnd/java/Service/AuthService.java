package com.ApiBackEnd.java.Service;

import com.ApiBackEnd.java.Model.AccessModel;
import com.ApiBackEnd.java.Model.AuthenticationModel;
import com.ApiBackEnd.java.Model.LoginRequest;
import com.ApiBackEnd.java.Security.jwt.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

@Service
public class AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    public ResponseEntity < AccessModel> login(AuthenticationModel authenticationModel){
        if (authenticationModel.getEmail() == null || authenticationModel.getPassword() == null) {
            logger.error("Username or password cannot be null");
            return ResponseEntity.badRequest().body(new AccessModel("Username and password are required"));
        }

            Collection<GrantedAuthority> authorities = new HashSet<>();
            authorities.add(new SimpleGrantedAuthority("USER"));
            authenticationModel.setAuthorities(authorities);
            try {
                LoginRequest login = new LoginRequest(authenticationModel.getEmail(), authenticationModel.getPassword(), authenticationModel.getAuthorities());
                String token = jwtUtils.generateTokenFromUserDetailsImpl(login);
                return ResponseEntity.ok(new AccessModel(token));


        } catch (BadCredentialsException e) {

            logger.error("Invalid credentials for user{}", authenticationModel.getEmail(), e);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new AccessModel("Invalid username or password"));

        } catch (Exception e) {

            logger.error("Unexpected error during authentication", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new AccessModel("Unexpected error during authentication"));
        }

    }
}
