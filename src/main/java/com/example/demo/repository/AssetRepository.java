package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Assetentity;

public interface AssetRepository extends JpaRepository<Assetentity, Long> {

    List<Assetentity> findByStatus(String status);
}
