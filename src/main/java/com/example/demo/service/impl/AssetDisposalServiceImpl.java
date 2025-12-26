package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.AssetDisposalService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetDisposalServiceImpl implements AssetDisposalService {
    @Autowired private AssetDisposalRepository disposalRepo;
    @Autowired private AssetRepository assetRepo;
    @Autowired private UserRepository userRepo;

    @Override
    public AssetDisposal requestDisposal(Long assetId, AssetDisposal d) {
        Asset a = assetRepo.findById(assetId).orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        if(d.getDisposalValue() < 0) throw new IllegalArgumentException("Negative Value Not Allowed");
        d.setAsset(a);
        return disposalRepo.save(d);
    }

    @Override
    public AssetDisposal approveDisposal(Long dId, Long adminId) {
        AssetDisposal d = disposalRepo.findById(dId).orElseThrow(() -> new ResourceNotFoundException("No Disposal"));
        User admin = userRepo.findById(adminId).orElseThrow(() -> new ResourceNotFoundException("No Admin"));
        
        Asset a = d.getAsset();
        a.setStatus("DISPOSED");
        assetRepo.save(a);
        
        d.setApprovedBy(admin);
        return disposalRepo.save(d);
    }
}