package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AssetServiceImpl implements AssetService {
    @Autowired private AssetRepository assetRepo;
    @Autowired private VendorRepository vendorRepo;
    @Autowired private DepreciationRuleRepository ruleRepo;

    @Override
    public Asset createAsset(Long vId, Long rId, Asset asset) {
        Vendor v = vendorRepo.findById(vId).orElseThrow(() -> new ResourceNotFoundException("Vendor Not Found"));
        DepreciationRule r = ruleRepo.findById(rId).orElseThrow(() -> new ResourceNotFoundException("Rule Not Found"));
        
        if (asset.getPurchaseCost() < 0) throw new IllegalArgumentException("Negative Cost Not Allowed");
        if (assetRepo.existsByAssetTag(asset.getAssetTag())) throw new IllegalArgumentException("Tag Exists");
        
        asset.setVendor(v);
        asset.setDepreciationRule(r);
        return assetRepo.save(asset);
    }

    @Override public List<Asset> getAllAssets() { return assetRepo.findAll(); }
    @Override public Asset getAsset(Long id) { return assetRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Asset Not Found")); }
    @Override public List<Asset> getAssetsByStatus(String s) { return assetRepo.findByStatus(s); }
}