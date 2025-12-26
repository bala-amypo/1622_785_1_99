package com.example.demo.controller;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public User register(@RequestBody Map<String, String> req) {

        User user = new User();
        user.setEmail(req.get("email"));
        user.setName(req.get("name"));
        user.setPassword(passwordEncoder.encode(req.get("password")));

        Role role = roleRepository.findByName("USER")
                .orElseGet(() -> roleRepository.save(new Role("USER")));

        user.getRoles().add(role);
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> req) {

        User user = userRepository.findByEmail(req.get("email"))
                .orElseThrow(() -> new RuntimeException("Invalid email"));

        if (!passwordEncoder.matches(req.get("password"), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        Set<String> roles = new HashSet<>();
        user.getRoles().forEach(r -> roles.add(r.getName()));

        String token = jwtUtil.generateToken(user.getEmail(), user.getId(), roles);
        return Map.of("token", token);
    }
}
