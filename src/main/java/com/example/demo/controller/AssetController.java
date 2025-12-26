package com.example.demo.controller;

import com.example.demo.entity.Asset;
import com.example.demo.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/assets")
public class AssetController {
    @Autowired private AssetService service;

    @PostMapping("/{vId}/{rId}")
    public Asset create(@PathVariable Long vId, @PathVariable Long rId, @RequestBody Asset a) {
        return service.createAsset(vId, rId, a);
    }

    @GetMapping
    public List<Asset> getAll() { return service.getAllAssets(); }

    @GetMapping("/{id}")
    public Asset getOne(@PathVariable Long id) { return service.getAsset(id); }

    @GetMapping("/status/{status}")
    public List<Asset> getStatus(@PathVariable String status) { return service.getAssetsByStatus(status); }
}