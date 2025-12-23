package com.example.demo.repository;

import com.example.demo.entity.AssetLifecycleEvententity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetLifecycleEventRepository
        extends JpaRepository<AssetLifecycleEvententity, Long> {
}
