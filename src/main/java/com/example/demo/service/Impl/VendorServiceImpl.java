package com.example.demo.service.Impl;
import com.example.demo.entity.Vendorentity;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    @Override
    public Vendorentity saveVendor(Vendorentity vendor) {
        return vendorRepository.save(vendor);
    }

    @Override
    public List<Vendorentity> getAllVendors() {
        return vendorRepository.findAll();
    }

    @Override
    public Vendorentity getVendorById(Long id) {
        return vendorRepository.findById(id).orElse(null);
    }
}
