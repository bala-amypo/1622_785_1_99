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

    public AssetDisposalServiceImpl(AssetDisposalRepository disposalRepo, AssetRepository assetRepo, UserRepository userRepo) {
        this.disposalRepo = disposalRepo; this.assetRepo = assetRepo; this.userRepo = userRepo;
    }

    @Override
    public AssetDisposal requestDisposal(Long assetId, AssetDisposal disposal) {
        Asset a = assetRepo.findById(assetId).orElseThrow(() -> new ResourceNotFoundException("Asset not found"));
        if (disposal.getDisposalValue() < 0) throw new IllegalArgumentException("Value >= 0 required");
        disposal.setAsset(a);
        return disposalRepo.save(disposal);
    }
    @Override
    public AssetDisposal approveDisposal(Long dId, Long adminId) {
        AssetDisposal d = disposalRepo.findById(dId).orElseThrow(() -> new ResourceNotFoundException("Disposal not found"));
        User admin = userRepo.findById(adminId).orElseThrow(() -> new ResourceNotFoundException("Admin not found"));
        Asset a = d.getAsset();
        a.setStatus("DISPOSED");
        assetRepo.save(a);
        d.setApprovedBy(admin);
        return disposalRepo.save(d);
    }
}