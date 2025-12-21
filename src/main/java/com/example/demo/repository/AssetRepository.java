package com.example.demo.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Assetentity;

@Repository
public interface AssetRepository extends JpaRepository<Assetentity,Long>{

}