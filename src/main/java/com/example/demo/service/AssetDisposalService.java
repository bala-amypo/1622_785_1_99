package com.example.demo.service;

import com.example.demo.entity.AssetDisposal;

public interface AssetDisposalService {
    AssetDisposal disposeAsset(Long assetId, AssetDisposal disposal);
}
