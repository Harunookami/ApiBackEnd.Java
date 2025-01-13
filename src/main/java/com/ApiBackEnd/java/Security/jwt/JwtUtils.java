package com.ApiBackEnd.java.Security.jwt;

import com.ApiBackEnd.java.Service.UserDetailsImpl;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);


    @Value("${project.jwtSecret}")
    private String jwtSecret;


    @Value("${project.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String generateTokenFromUserDetailsImpl(UserDetailsImpl userDetail) {
        return Jwts.builder()
                .setSubject(userDetail.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
                .signWith(getSigninKey(), SignatureAlgorithm.HS512)
                .compact();
    }

    public Key getSigninKey (){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public String getUsernameToken(String token) {
        return Jwts.parser()
                .setSigningKey(getSigninKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateJwtToken(String authToken) {

        try {
            Jwts.parser()
                    .setSigningKey(getSigninKey())
                    .build()
                    .parseClaimsJws(authToken);

        return true;

        } catch (MalformedJwtException e) {
            logger.error("Invalid Token" + e.getMessage());

        } catch (ExpiredJwtException e) {
            logger.error("Expired Token" + e.getMessage());
        } catch (UnsupportedJwtException e){
            logger.error("Unsupported Token" + e.getMessage());
        }

        return false;
    }
}
