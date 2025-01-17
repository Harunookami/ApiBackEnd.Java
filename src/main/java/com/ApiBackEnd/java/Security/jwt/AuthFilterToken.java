package com.ApiBackEnd.java.Security.jwt;

import com.ApiBackEnd.java.Model.UserModel;
import com.ApiBackEnd.java.Repository.UserRepository;
import com.ApiBackEnd.java.Service.AuthService;
import com.ApiBackEnd.java.Service.UserDetailServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collection;

@Component
public class AuthFilterToken extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(AuthFilterToken.class);

    @Autowired
    private JwtUtils jwtUtil;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;

    private UserModel userModel;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            String jwt = getToken(request);

            if (jwt != null && jwtUtil.validateJwtToken(jwt)) {
             String email = jwtUtil.getUsernameToken(jwt);

             if (email != null) {
                 UserDetails userDetails = userDetailService.loadUserByUsername(email);

                 Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();

                 UsernamePasswordAuthenticationToken authentication =
                         new UsernamePasswordAuthenticationToken(userDetails, null, authorities);
                 authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                 SecurityContextHolder.getContext().setAuthentication(authentication);
             }
            }


        } catch (Exception e) {
            logger.error("Error authenticating token: {} - {}", e.getClass().getSimpleName(), e.getMessage());

        } finally {
            filterChain.doFilter(request, response);
        }

    }

    private String getToken(HttpServletRequest request) {
        String headerToken = request.getHeader("Authorization");

        if (StringUtils.hasText(headerToken) && headerToken.startsWith("Bearer")) {
            return headerToken.replace("Bearer ", "");
        }

        return null;
    }
}
