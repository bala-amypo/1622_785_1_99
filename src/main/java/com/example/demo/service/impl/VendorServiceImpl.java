package com.example.demo.service.impl;

import com.example.demo.entity.Vendor;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.VendorService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {
    private final VendorRepository repo;
    public VendorServiceImpl(VendorRepository repo) { this.repo = repo; }

    @Override
    public Vendor createVendor(Vendor v) {
        if (repo.findByVendorName(v.getVendorName()).isPresent()) throw new IllegalArgumentException("Exists");
        return repo.save(v);
    }
    @Override public List<Vendor> getAllVendors() { return repo.findAll(); }
}