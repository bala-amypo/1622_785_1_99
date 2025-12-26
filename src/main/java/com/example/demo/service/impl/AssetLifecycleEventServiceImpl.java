package com.example.demo.service.impl;

import com.example.demo.entity.Asset;
import com.example.demo.entity.AssetLifecycleEvent;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AssetLifecycleEventRepository;
import com.example.demo.repository.AssetRepository;
import com.example.demo.service.AssetLifecycleEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetLifecycleEventServiceImpl implements AssetLifecycleEventService {

    @Autowired
    private AssetLifecycleEventRepository repository;

    @Autowired
    private AssetRepository assetRepository;

    @Override
    public AssetLifecycleEvent saveEvent(Long assetId, AssetLifecycleEvent event) {
        Asset asset = assetRepository.findById(assetId)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found"));
        event.setAsset(asset);
        return repository.save(event);
    }

    @Override
    public List<AssetLifecycleEvent> getEventsByAsset(Long assetId) {
        return repository.findByAssetId(assetId);
    }
}
