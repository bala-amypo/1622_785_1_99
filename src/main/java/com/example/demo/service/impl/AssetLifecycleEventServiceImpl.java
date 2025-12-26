package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.AssetLifecycleEventService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class AssetLifecycleEventServiceImpl implements AssetLifecycleEventService {
    @Autowired private AssetLifecycleEventRepository eventRepo;
    @Autowired private AssetRepository assetRepo;

    @Override
    public AssetLifecycleEvent logEvent(Long assetId, AssetLifecycleEvent event) {
        Asset a = assetRepo.findById(assetId).orElseThrow(() -> new ResourceNotFoundException("Asset Not Found"));
        if(event.getEventDate().isAfter(LocalDate.now())) throw new IllegalArgumentException("Future Date Not Allowed");
        if(event.getEventDescription() == null || event.getEventDescription().isEmpty()) throw new IllegalArgumentException("Description Empty");
        
        event.setAsset(a);
        return eventRepo.save(event);
    }

    @Override
    public List<AssetLifecycleEvent> getEventsForAsset(Long assetId) {
        return eventRepo.findByAssetIdOrderByEventDateDesc(assetId);
    }
}