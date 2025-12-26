package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired private UserRepository userRepo;
    @Autowired private RoleRepository roleRepo;
    @Autowired private PasswordEncoder encoder;
    @Autowired private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> req) {
        User u = new User();
        u.setEmail(req.get("email"));
        u.setName(req.get("name"));
        u.setPassword(encoder.encode(req.get("password")));
        
        Role userRole = roleRepo.findByName("USER").orElseGet(() -> roleRepo.save(new Role("USER")));
        u.getRoles().add(userRole);
        return ResponseEntity.ok(userRepo.save(u));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> req) {
        User u = userRepo.findByEmail(req.get("email")).orElseThrow();
        if(!encoder.matches(req.get("password"), u.getPassword())) return ResponseEntity.status(401).build();
        
        Set<String> roleNames = u.getRoles().stream().map(Role::getName).collect(Collectors.toSet());
        String token = jwtUtil.generateToken(u.getEmail(), u.getId(), roleNames);
        
        Map<String, Object> resp = new HashMap<>();
        resp.put("token", token);
        resp.put("userId", u.getId());
        resp.put("email", u.getEmail());
        resp.put("roles", roleNames);
        return ResponseEntity.ok(resp);
    }
}