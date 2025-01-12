package com.ApiBackEnd.java.Service;

import com.ApiBackEnd.java.Model.AccessModel;
import com.ApiBackEnd.java.Model.AuthenticationModel;
import com.ApiBackEnd.java.Security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

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

            AccessModel accessModel = new AccessModel(token);

            return accessModel;

        } catch (BadCredentialsException e) {

        }
    }
}
