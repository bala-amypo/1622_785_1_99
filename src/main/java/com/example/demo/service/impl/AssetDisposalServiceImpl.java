package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.AssetDisposalService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AssetDisposalServiceImpl implements AssetDisposalService {
    private final AssetDisposalRepository disposalRepo;
    private final AssetRepository assetRepo;
    private final UserRepository userRepo;

    public AssetDisposalServiceImpl(AssetDisposalRepository d, AssetRepository a, UserRepository u) {
        this.disposalRepo = d; this.assetRepo = a; this.userRepo = u;
    }

    @Override
    public AssetDisposal requestDisposal(Long assetId, AssetDisposal d) {
        Asset a = assetRepo.findById(assetId).orElseThrow(() -> new ResourceNotFoundException("Asset"));
        if (d.getDisposalValue() < 0) throw new IllegalArgumentException("Value >= 0");
        d.setAsset(a);
        return disposalRepo.save(d);
    }

    @Override
    public AssetDisposal approveDisposal(Long dId, Long adminId) {
        AssetDisposal d = disposalRepo.findById(dId).orElseThrow(() -> new ResourceNotFoundException("Disposal"));
        User admin = userRepo.findById(adminId).orElseThrow(() -> new ResourceNotFoundException("Admin"));
        Asset a = d.getAsset();
        a.setStatus("DISPOSED");
        assetRepo.save(a);
        d.setApprovedBy(admin);
        return disposalRepo.save(d);
    }
}