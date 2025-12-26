package com.example.demo.util;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Set;

@Component
public class JwtUtil {

    private static final String SECRET = "secret123";
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 10; // 10 hours

    // ✅ USED BY AuthController
    public String generateToken(String email, Long userId, Set<String> roles) {
        return Jwts.builder()
                .claim("email", email)
                .claim("userId", userId)
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    // ✅ USED BY JwtFilter
    public boolean validateToken(String token) {
        try {
            getClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // ✅ USED BY JwtFilter
    public Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }
}
