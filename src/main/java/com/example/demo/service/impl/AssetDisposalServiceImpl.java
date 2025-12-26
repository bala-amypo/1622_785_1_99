package com.example.demo.service.impl;

import com.example.demo.entity.Asset;
import com.example.demo.entity.AssetDisposal;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AssetDisposalRepository;
import com.example.demo.repository.AssetRepository;
import com.example.demo.service.AssetDisposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetDisposalServiceImpl implements AssetDisposalService {

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private AssetDisposalRepository disposalRepository;

    @Override
    public AssetDisposal disposeAsset(Long assetId, AssetDisposal disposal) {
        Asset asset = assetRepository.findById(assetId)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found"));

        asset.setStatus("DISPOSED");
        disposal.setAsset(asset);

        assetRepository.save(asset);
        return disposalRepository.save(disposal);
    }
}
