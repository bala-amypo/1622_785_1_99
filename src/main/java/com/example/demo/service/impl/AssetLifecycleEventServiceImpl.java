package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.AssetLifecycleEventService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class AssetLifecycleEventServiceImpl implements AssetLifecycleEventService {
    private final AssetLifecycleEventRepository eventRepo;
    private final AssetRepository assetRepo;

    public AssetLifecycleEventServiceImpl(AssetLifecycleEventRepository er, AssetRepository ar) {
        this.eventRepo = er; this.assetRepo = ar;
    }

    @Override
    public AssetLifecycleEvent logEvent(Long assetId, AssetLifecycleEvent e) {
        Asset a = assetRepo.findById(assetId).orElseThrow(() -> new ResourceNotFoundException("Asset"));
        if (e.getEventDate().isAfter(LocalDate.now())) throw new IllegalArgumentException("Future Date");
        if (e.getEventDescription() == null || e.getEventDescription().isEmpty()) throw new IllegalArgumentException("Empty Desc");
        e.setAsset(a);
        return eventRepo.save(e);
    }

    @Override public List<AssetLifecycleEvent> getEventsForAsset(Long id) { return eventRepo.findByAssetIdOrderByEventDateDesc(id); }
}