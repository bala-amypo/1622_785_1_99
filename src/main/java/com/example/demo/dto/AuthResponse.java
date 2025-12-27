package com.example.demo.dto;

import java.util.Set;

public class AuthResponse {

    private String token;
    private Long userId;
    private String email;
    private Set<String> roles;

    // ✅ REQUIRED by Jackson
    public AuthResponse() {
    }

    // Existing constructor (keep)
    public AuthResponse(String token, Long userId, String email, Set<String> roles) {
        this.token = token;
        this.userId = userId;
        this.email = email;
        this.roles = roles;
    }

    // Optional: token-only constructor (harmless, test-friendly)
    public AuthResponse(String token) {
        this.token = token;
    }

    // Getters and Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
