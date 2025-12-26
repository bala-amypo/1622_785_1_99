package com.example.demo.service.impl;

import com.example.demo.entity.Asset;
import com.example.demo.entity.AssetLifecycleEvent;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AssetLifecycleEventRepository;
import com.example.demo.repository.AssetRepository;
import com.example.demo.service.AssetLifecycleEventService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class AssetLifecycleEventServiceImpl implements AssetLifecycleEventService {
    private final AssetLifecycleEventRepository eventRepo;
    private final AssetRepository assetRepo;

    public AssetLifecycleEventServiceImpl(AssetLifecycleEventRepository eventRepo, AssetRepository assetRepo) {
        this.eventRepo = eventRepo;
        this.assetRepo = assetRepo;
    }

    @Override
    public AssetLifecycleEvent logEvent(Long assetId, AssetLifecycleEvent event) {
        Asset asset = assetRepo.findById(assetId)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found"));

        // PDF Rule 2.6 & 6.4
        if (event.getEventType() == null || event.getEventType().isEmpty())
            throw new IllegalArgumentException("Event type required");
        if (event.getEventDescription() == null || event.getEventDescription().trim().isEmpty())
            throw new IllegalArgumentException("Description cannot be blank");
        if (event.getEventDate() != null && event.getEventDate().isAfter(LocalDate.now()))
            throw new IllegalArgumentException("Event date cannot be in future");

        event.setAsset(asset);
        return eventRepo.save(event);
    }

    @Override
    public List<AssetLifecycleEvent> getEventsForAsset(Long assetId) {
        if (!assetRepo.existsById(assetId)) throw new ResourceNotFoundException("Asset not found");
        return eventRepo.findByAssetIdOrderByEventDateDesc(assetId);
    }
}