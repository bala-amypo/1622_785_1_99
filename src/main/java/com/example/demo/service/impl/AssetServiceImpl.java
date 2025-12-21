package com.example.demo.service.impl;
import com.example.demo.entity.Assetentity;
import com.example.demo.repository.AssetRepository;
import com.example.demo.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    private AssetRepository assetRepository;

    @Override
    public Assetentity saveAsset(Assetentity asset) {
        return assetRepository.save(asset);
    }

    @Override
    public List<Assetentity> getAllAssets() {
        return assetRepository.findAll();
    }

    @Override
    public List<Assetentity> getAssetsByStatus(String status) {
        return assetRepository.findByStatus(status);
    }

    @Override
    public Assetentity getAssetById(Long id) {
        return assetRepository.findById(id).orElse(null);
    }
}
