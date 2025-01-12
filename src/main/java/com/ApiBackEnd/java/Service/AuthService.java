package com.ApiBackEnd.java.Service;

import com.ApiBackEnd.java.Model.AccessModel;
import com.ApiBackEnd.java.Model.AuthenticationModel;
import com.ApiBackEnd.java.Security.jwt.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    public AccessModel login(AuthenticationModel authenticationModel){

        try {
            UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken
                    (authenticationModel.getUsername(), authenticationModel.getPassword());

            Authentication authentication = authenticationManager.authenticate(userAuth);

            UserDetailsImpl userAuthenticate = (UserDetailsImpl) authentication.getPrincipal();

            String token = jwtUtils.generateTokenFromUserDetailsImpl(userAuthenticate);

            return new AccessModel(token);


        } catch (BadCredentialsException e) {
            logger.error("Invalid credentials for user{}", authenticationModel.getUsername(), e);
            return new AccessModel("Invalid username or password");
        } catch (Exception e) {
            logger.error("Unexpected error during authentication", e);
            return new AccessModel("Unexpected error during authentication");
        }

    }
}
