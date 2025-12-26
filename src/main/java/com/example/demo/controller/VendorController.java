package com.example.demo.controller;

import com.example.demo.entity.Vendor;
import com.example.demo.service.VendorService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {
    private final VendorService service;
    public VendorController(VendorService service) { this.service = service; }
    @PostMapping public Vendor create(@RequestBody Vendor v) { return service.createVendor(v); }
    @GetMapping public List<Vendor> list() { return service.getAllVendors(); }
}