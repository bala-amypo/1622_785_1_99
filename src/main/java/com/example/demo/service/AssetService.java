package com.example.demo.service;
import com.example.demo.entity.Assetentity;
import java.util.List;
public interface AssetService {
    Assetentity saveAsset(Assetentity asset);
    List<Assetentity> getAllAssets();
    List<Assetentity> getAssetsByStatus(String status);
    Assetentity getAssetById(Long id);
}
