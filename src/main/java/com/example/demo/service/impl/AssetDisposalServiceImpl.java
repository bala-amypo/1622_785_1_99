package com.example.demo.service.impl;

import com.example.demo.entity.Asset;
import com.example.demo.entity.AssetDisposal;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AssetDisposalRepository;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AssetDisposalService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AssetDisposalServiceImpl implements AssetDisposalService {
    private final AssetDisposalRepository disposalRepo;
    private final AssetRepository assetRepo;
    private final UserRepository userRepo;

    public AssetDisposalServiceImpl(AssetDisposalRepository d, AssetRepository a, UserRepository u) {
        this.disposalRepo = d; this.assetRepo = a; this.userRepo = u;
    }

    @Override
    public AssetDisposal requestDisposal(Long assetId, AssetDisposal disposal) {
        Asset asset = assetRepo.findById(assetId)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found"));
        
        if (disposal.getDisposalValue() != null && disposal.getDisposalValue() < 0)
            throw new IllegalArgumentException("Disposal value must be >= 0");

        disposal.setAsset(asset);
        return disposalRepo.save(disposal);
    }

    @Override
    @Transactional
    public AssetDisposal approveDisposal(Long disposalId, Long adminId) {
        AssetDisposal disposal = disposalRepo.findById(disposalId)
                .orElseThrow(() -> new ResourceNotFoundException("Disposal not found"));
        User admin = userRepo.findById(adminId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        // Set approvedBy and update status (PDF Rule 2.7 & 6.5)
        Asset asset = disposal.getAsset();
        asset.setStatus("DISPOSED");
        assetRepo.save(asset);

        disposal.setApprovedBy(admin);
        return disposalRepo.save(disposal);
    }
}