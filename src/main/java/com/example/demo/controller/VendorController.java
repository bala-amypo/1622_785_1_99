package com.example.demo.controller;

import com.example.demo.entity.Vendor;
import com.example.demo.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {
    @Autowired private VendorService service;
    @PostMapping public Vendor create(@RequestBody Vendor v) { return service.createVendor(v); }
    @GetMapping public List<Vendor> getAll() { return service.getAllVendors(); }
}