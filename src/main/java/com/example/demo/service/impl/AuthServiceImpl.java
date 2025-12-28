package com.example.demo.service.impl;

import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User register(RegisterRequestDto req) {
        User user = new User();
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        user.setPassword(passwordEncoder.encode(req.getPassword()));

        Set<String> requestedRoles = req.getRoles();
        Set<Role> rolesToAssign = new HashSet<>();

        if (requestedRoles == null || requestedRoles.isEmpty()) {
            // default USER role
            Role defaultRole = roleRepository.findByName("USER").orElseGet(() -> new Role("USER"));
            rolesToAssign.add(defaultRole);
        } else {
            for (String r : requestedRoles) {
                Role role = roleRepository.findByName(r).orElseGet(() -> new Role(r));
                rolesToAssign.add(role);
            }
        }

        user.setRoles(rolesToAssign);

        return userRepository.save(user);
    }

    @Override
    public User login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return user;
    }
}
