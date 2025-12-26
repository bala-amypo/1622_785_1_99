package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.UserService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository ur, RoleRepository rr, PasswordEncoder e) {
        this.userRepo = ur; this.roleRepo = rr; this.encoder = e;
    }

    @Override
    public User registerUser(User u) {
        u.setPassword(encoder.encode(u.getPassword()));
        Role userRole = roleRepo.findByName("USER").orElseGet(() -> roleRepo.save(new Role("USER")));
        u.getRoles().add(userRole);
        return userRepo.save(u);
    }
    @Override public User findByEmail(String e) { return userRepo.findByEmail(e).orElseThrow(() -> new ResourceNotFoundException("User")); }
    @Override public User findById(Long id) { return userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User")); }
}