package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.AssetDisposalentity;
import com.example.demo.service.AssetDisposalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disposals")
public class AssetDisposalController {
@Autowired
    private  AssetDisposalService disposalService;

    public AssetDisposalController(AssetDisposalService disposalService) {
        this.disposalService = disposalService;
    }

    @PostMapping
    public AssetDisposalentity saveDisposal(@RequestBody AssetDisposalentity disposal) {
        return disposalService.saveDisposal(disposal);
    }

    @GetMapping
    public List<AssetDisposalentity> getAllDisposals() {
        return disposalService.getAllDisposals();
    }
}
