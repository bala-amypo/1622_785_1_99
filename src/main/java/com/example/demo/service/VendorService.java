package com.example.demo.service;
import com.example.demo.entity.Vendorentity;
import java.util.List;
public interface VendorService {
    Vendorentity saveVendor(Vendorentity vendor);

    List<Vendorentity> getAllVendors();

    Vendorentity getVendorById(Long id);
}
