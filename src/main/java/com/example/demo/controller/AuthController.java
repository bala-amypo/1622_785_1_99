package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.*;
import com.example.demo.util.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder encoder;

    public AuthController(UserService userService, JwtUtil jwtUtil, PasswordEncoder encoder) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.encoder = encoder;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest req) {
        User u = userService.findByEmail(req.getEmail());
        if(!encoder.matches(req.getPassword(), u.getPassword())) return ResponseEntity.status(401).build();
        
        var roles = u.getRoles().stream().map(Role::getName).collect(Collectors.toSet());
        String token = jwtUtil.generateToken(u.getEmail(), u.getId(), roles);
        return ResponseEntity.ok(new AuthResponse(token, u.getId(), u.getEmail(), roles));
    }
}