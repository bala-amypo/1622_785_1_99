package com.example.demo.repository;

import com.example.demo.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * PDF Rule 4.4: Extra method findByVendorName required.
 */
public interface VendorRepository extends JpaRepository<Vendor, Long> {
    Optional<Vendor> findByVendorName(String vendorName);
}