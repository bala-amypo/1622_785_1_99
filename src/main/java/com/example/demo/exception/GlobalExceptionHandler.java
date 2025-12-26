package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handle404(ResourceNotFoundException e) { return ResponseEntity.status(404).body(e.getMessage()); }
    
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handle400(IllegalArgumentException e) { return ResponseEntity.status(400).body(e.getMessage()); }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handle500(Exception e) { return ResponseEntity.status(500).body(e.getMessage()); }
}