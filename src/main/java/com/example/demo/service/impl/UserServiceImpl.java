package com.example.demo.service.impl;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
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
    public User registerUser(User user) {
        if (userRepo.findByEmail(user.getEmail()).isPresent()) 
            throw new IllegalArgumentException("Email exists");
        
        user.setPassword(encoder.encode(user.getPassword()));
        
        Role userRole = roleRepo.findByName("USER")
                .orElseGet(() -> roleRepo.save(new Role("USER")));
        user.getRoles().add(userRole);
        
        return userRepo.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public User findById(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}