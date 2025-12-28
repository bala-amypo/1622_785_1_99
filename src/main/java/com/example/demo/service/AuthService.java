package com.example.demo.service;

import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.entity.User;

public interface AuthService {
    User register(RegisterRequestDto req);
    User login(String email, String password);
}
