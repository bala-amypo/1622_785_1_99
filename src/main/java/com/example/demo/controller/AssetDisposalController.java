package com.example.demo.controller;

import com.example.demo.entity.AssetDisposal;
import com.example.demo.service.AssetDisposalService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/disposals")
public class AssetDisposalController {
    private final AssetDisposalService service;
    public AssetDisposalController(AssetDisposalService s) { this.service = s; }
    @PostMapping("/request/{id}") public AssetDisposal req(@PathVariable Long id, @RequestBody AssetDisposal d) { return service.requestDisposal(id, d); }
    @PutMapping("/approve/{dId}/{aId}") public AssetDisposal app(@PathVariable Long dId, @PathVariable Long aId) { return service.approveDisposal(dId, aId); }
}