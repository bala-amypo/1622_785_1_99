package com.example.demo.service;

import com.example.demo.entity.Asset;
import java.util.List;

public interface AssetService {

    Asset saveAsset(Asset asset);

    Asset getAssetById(Long id);

    List<Asset> getAllAssets();

    List<Asset> getAssetsByStatus(String status);
}
