package com.example.demo.service;
import com.example.demo.entity.Assetentity;
import java.util.List;

public interface AssetService {

    Assetentity saveAsset(Assetentity asset);

    List<Assetentity> getAllAssets();

    Assetentity getAssetById(Long id);

    void deleteAsset(Long id);
}
