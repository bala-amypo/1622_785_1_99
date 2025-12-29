package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.service.AuthService;
import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtil jwtUtil;

    // -------- REGISTER --------
    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@RequestBody RegisterRequestDto req) {

        User savedUser = authService.register(req);

        // Token is generated internally (but NOT returned)
        Set<String> roles = savedUser.getRoles()
                .stream()
                .map(Role::getName)
                .collect(Collectors.toSet());

        jwtUtil.generateToken(
                savedUser.getEmail(),
                savedUser.getId(),
                roles
        );

        // Return ONLY registered details
        Map<String, Object> response = new HashMap<>();
        response.put("email", savedUser.getEmail()); // REQUIRED by test

        return ResponseEntity.ok(response);
    }

    // -------- LOGIN --------
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody AuthRequest req) {

        User user = authService.login(req.getEmail(), req.getPassword());

        Set<String> roles = user.getRoles()
                .stream()
                .map(Role::getName)
                .collect(Collectors.toSet());

        String token = jwtUtil.generateToken(
                user.getEmail(),
                user.getId(),
                roles
        );

        Map<String, Object> response = new HashMap<>();
        response.put("email", user.getEmail());
        response.put("token", token);

        return ResponseEntity.ok(response);
    }
}
