package com.example.demo.controller;

import com.example.demo.entity.AssetDisposal;
import com.example.demo.service.AssetDisposalService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disposals")
public class AssetDisposalController {

    private final AssetDisposalService disposalService;

    public AssetDisposalController(AssetDisposalService disposalService) {
        this.disposalService = disposalService;
    }

    @PostMapping
    public AssetDisposal createDisposal(@Valid @RequestBody AssetDisposal disposal) {
        return disposalService.saveDisposal(disposal);
    }

    @GetMapping("/approver/{userId}")
    public List<AssetDisposal> getDisposalsByApprover(@PathVariable Long userId) {
        return disposalService.getDisposalsByApprover(userId);
    }
}
