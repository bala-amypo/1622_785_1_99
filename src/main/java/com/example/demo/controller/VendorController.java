package com.example.demo.controller;

import com.example.demo.entity.Vendorentity;
import com.example.demo.service.VendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {
@Autowired
    private VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    // CREATE
    @PostMapping
    public Vendorentity saveVendor(@RequestBody Vendorentity vendor) {
        return vendorService.saveVendor(vendor);
    }

    // READ ALL
    @GetMapping
    public List<Vendorentity> getAllVendors() {
        return vendorService.getAllVendors();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Vendorentity getVendorById(@PathVariable Long id) {
        return vendorService.getVendorById(id);
    }
}
