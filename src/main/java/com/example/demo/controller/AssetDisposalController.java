package com.example.demo.controller;

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

    // CREATE
    @PostMapping
    public AssetDisposalentity saveDisposal(@RequestBody AssetDisposalentity disposal) {
        return disposalService.saveDisposal(disposal);
    }

    // READ ALL
    @GetMapping
    public List<AssetDisposalentity> getAllDisposals() {
        return disposalService.getAllDisposals();
    }
}
