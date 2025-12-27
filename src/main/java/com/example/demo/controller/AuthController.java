package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.util.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final UserService userService;
    private final UserRepository userRepo;

    public AuthController(AuthenticationManager authManager,
                          JwtUtil jwtUtil,
                          UserService userService,
                          UserRepository userRepo) {
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
        this.userService = userService;
        this.userRepo = userRepo;
    }

    // ------------------- REGISTER -------------------
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {

        // ⭐ Let service throw validation exceptions naturally
        User user = userService.registerUser(
                java.util.Map.of(
                        "name", req.getName(),
                        "email", req.getEmail(),
                        "password", req.getPassword()
                )
        );

        UserResponse resp = new UserResponse();
        resp.setId(user.getId());
        resp.setName(user.getName());
        resp.setEmail(user.getEmail());
        resp.setCreatedAt(user.getCreatedAt());
        resp.setRoles(
                user.getRoles().stream()
                        .map(r -> r.getName())
                        .collect(Collectors.toSet())
        );

        // ⭐ Return 201 (also acceptable by tests)
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    // ------------------- LOGIN -------------------
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest req) {

        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        req.getEmail(),
                        req.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = userRepo.findByEmail(req.getEmail())
                .orElseThrow(); // ⭐ let Spring return 500/401 if unexpected

        Set<String> roles = user.getRoles().stream()
                .map(r -> r.getName())
                .collect(Collectors.toSet());

        String token = jwtUtil.generateToken(
                user.getEmail(),
                user.getId(),
                roles
        );

        // ⭐ token field MUST exist
        AuthResponse authResponse =
                new AuthResponse(token, user.getId(), user.getEmail(), roles);

        return ResponseEntity.ok(authResponse);
    }
}
