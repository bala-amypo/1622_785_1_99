package com.example.demo.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.AssetLifecycleentity;

@Repository
public interface AssetLifecycleRepository extends JpaRepository<AssetLifecycleentity,Long>{

}