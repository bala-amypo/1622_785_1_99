package com.example.demo.controller;

import com.example.demo.entity.AssetDisposal;
import com.example.demo.service.AssetDisposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/disposals")
public class AssetDisposalController {

    @Autowired
    private AssetDisposalService service;

    @PostMapping("/{assetId}")
    public AssetDisposal dispose(@PathVariable Long assetId,
                                 @RequestBody AssetDisposal disposal) {
        return service.disposeAsset(assetId, disposal);
    }
}
