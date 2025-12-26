package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.AssetService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AssetServiceImpl implements AssetService {
    private final AssetRepository assetRepo;
    private final VendorRepository vendorRepo;
    private final DepreciationRuleRepository ruleRepo;

    public AssetServiceImpl(AssetRepository assetRepo, VendorRepository vendorRepo, DepreciationRuleRepository ruleRepo) {
        this.assetRepo = assetRepo;
        this.vendorRepo = vendorRepo;
        this.ruleRepo = ruleRepo;
    }

    @Override
    public Asset createAsset(Long vId, Long rId, Asset asset) {
        Vendor v = vendorRepo.findById(vId).orElseThrow(() -> new ResourceNotFoundException("Vendor missing"));
        DepreciationRule r = ruleRepo.findById(rId).orElseThrow(() -> new ResourceNotFoundException("Rule missing"));
        
        if (asset.getPurchaseCost() <= 0) throw new IllegalArgumentException("Cost must be > 0");
        if (assetRepo.existsByAssetTag(asset.getAssetTag())) throw new IllegalArgumentException("Tag exists");
        
        asset.setVendor(v);
        asset.setDepreciationRule(r);
        return assetRepo.save(asset);
    }

    @Override public List<Asset> getAssetsByStatus(String s) { return assetRepo.findByStatus(s); }
    @Override public List<Asset> getAllAssets() { return assetRepo.findAll(); }
    @Override public Asset getAsset(Long id) { return assetRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Asset missing")); }
}