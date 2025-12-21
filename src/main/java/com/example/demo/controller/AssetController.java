package com.example.demo.controller;

import com.example.demo.entity.Assetentity;
import com.example.demo.service.AssetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
public class AssetController {

    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    // CREATE
    @PostMapping
    public Assetentity saveAsset(@RequestBody Assetentity asset) {
        return assetService.saveAsset(asset);
    }

    // READ ALL
    @GetMapping
    public List<Assetentity> getAllAssets() {
        return assetService.getAllAssets();
    }

    // READ BY STATUS
    @GetMapping("/status/{status}")
    public List<Assetentity> getAssetsByStatus(@PathVariable String status) {
        return assetService.getAssetsByStatus(status);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Asset getAssetById(@PathVariable Long id) {
        return assetService.getAssetById(id);
    }
}
