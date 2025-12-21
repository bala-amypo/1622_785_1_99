package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.Assetentity;
import com.example.demo.service.AssetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
public class AssetController {
@Autowired
    private  AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }
    @PostMapping
    public Assetentity saveAsset(@RequestBody Assetentity asset) {
        return assetService.saveAsset(asset);
    }
    @GetMapping
    public List<Assetentity> getAllAssets() {
        return assetService.getAllAssets();
    }
    @GetMapping("/status/{status}")
    public List<Assetentity> getAssetsByStatus(@PathVariable String status) {
        return assetService.getAssetsByStatus(status);
    }
    @GetMapping("/{id}")
    public Assetentity getAssetById(@PathVariable Long id) {
        return assetService.getAssetById(id);
    }
}
