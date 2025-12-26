package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
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

    private final JwtUtil jwtUtil;
    private final UserService userService;
    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder passwordEncoder;

    public AuthController(
            JwtUtil jwtUtil,
            UserService userService,
            UserRepository userRepo,
            RoleRepository roleRepo,
            PasswordEncoder passwordEncoder
    ) {
        this.jwtUtil = jwtUtil;
        this.userService = userService;
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    // ---------------- REGISTER ----------------
    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@RequestBody Map<String, String> body) {

        User user = new User();
        user.setEmail(body.get("email"));
        user.setName(body.get("name"));
        user.setPassword(passwordEncoder.encode(body.get("password")));

        Role role = roleRepo.findByName("USER")
                .orElseGet(() -> roleRepo.save(new Role("USER")));

        user.getRoles().add(role);
        User saved = userRepo.save(user);

        Map<String, Object> response = new HashMap<>();
        response.put("id", saved.getId());
        response.put("email", saved.getEmail());
        response.put("name", saved.getName());

        return ResponseEntity.ok(response);
    }

    // ---------------- LOGIN ----------------
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest req) {

        User user = userRepo.findByEmail(req.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
            return ResponseEntity.status(401)
                    .body(Collections.singletonMap("error", "Invalid credentials"));
        }

        Set<String> roles = user.getRoles()
                .stream()
                .map(Role::getName)
                .collect(Collectors.toSet());

        String token = jwtUtil.generateToken(
                user.getEmail(),
                user.getId(),
                roles
        );

        return ResponseEntity.ok(
                new AuthResponse(token, user.getId(), user.getEmail(), roles)
        );
    }
}
