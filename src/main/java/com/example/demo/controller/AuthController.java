package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.entity.User;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Registration
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequestDto req) {
        User savedUser = authService.register(req);
        return ResponseEntity.status(201).body(savedUser);
    }

    // Login
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody AuthRequest req) {
        User user = authService.login(req.getEmail(), req.getPassword());
        return ResponseEntity.ok(user);
    }
}
