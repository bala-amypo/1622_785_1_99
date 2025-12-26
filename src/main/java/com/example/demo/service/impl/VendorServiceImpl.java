package com.example.demo.service.impl;

import com.example.demo.entity.Vendor;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {
    @Autowired private VendorRepository repo;

    @Override
    public Vendor createVendor(Vendor v) {
        if(repo.findByVendorName(v.getVendorName()).isPresent()) throw new IllegalArgumentException("Name Duplicate");
        return repo.save(v);
    }
    @Override public List<Vendor> getAllVendors() { return repo.findAll(); }
}