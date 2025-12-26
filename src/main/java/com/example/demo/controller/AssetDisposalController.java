package com.example.demo.controller;

import com.example.demo.entity.AssetDisposal;
import com.example.demo.service.AssetDisposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/disposals")
public class AssetDisposalController {
    @Autowired private AssetDisposalService service;

    @PostMapping("/request/{assetId}")
    public AssetDisposal req(@PathVariable Long assetId, @RequestBody AssetDisposal d) {
        return service.requestDisposal(assetId, d);
    }

    @PutMapping("/approve/{dId}/{adminId}")
    public AssetDisposal app(@PathVariable Long dId, @PathVariable Long adminId) {
        return service.approveDisposal(dId, adminId);
    }
}