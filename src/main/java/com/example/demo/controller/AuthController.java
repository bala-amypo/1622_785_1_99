package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.UserService;
import com.example.demo.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService service;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder encoder;

    public AuthController(UserService s, JwtUtil j, PasswordEncoder e) {
        this.service = s; this.jwtUtil = j; this.encoder = e;
    }

    @PostMapping("/register")
    public User register(@RequestBody User u) { return service.registerUser(u); }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> req) {
        User u = service.findByEmail(req.get("email"));
        if (!encoder.matches(req.get("password"), u.getPassword())) return ResponseEntity.status(401).build();
        Set<String> roles = u.getRoles().stream().map(Role::getName).collect(Collectors.toSet());
        String token = jwtUtil.generateToken(u.getEmail(), u.getId(), roles);
        return ResponseEntity.ok(Map.of("token", token, "email", u.getEmail(), "userId", u.getId(), "roles", roles));
    }
}