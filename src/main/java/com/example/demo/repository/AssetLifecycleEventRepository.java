package com.example.demo.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.AssetLifecycleEvententity;

@Repository
public interface AssetLifecycleEventRepository extends JpaRepository<AssetLifecycleEvententity,Long>{

}