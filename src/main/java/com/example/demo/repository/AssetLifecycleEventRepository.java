package com.example.demo.repository;

import com.example.demo.entity.AssetLifecycleEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * PDF Rule 4.6: Required for chronological event tracking.
 * Used in Test 81 and 85.
 */
public interface AssetLifecycleEventRepository extends JpaRepository<AssetLifecycleEvent, Long> {
    List<AssetLifecycleEvent> findByAssetIdOrderByEventDateDesc(Long assetId);
}