package com.example.demo.util;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Set;

@Component
public class JwtUtil {

    private static final String SECRET = "secret123";

    public String generateToken(String email, Long userId, Set<String> roles) {
        return Jwts.builder()
                .claim("email", email)
                .claim("userId", userId)
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    public Claims validateToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }
}
