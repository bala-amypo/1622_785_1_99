package com.example.demo.controller;

import com.example.demo.entity.AssetLifecycleEvent;
import com.example.demo.service.AssetLifecycleEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lifecycle-events")
public class AssetLifecycleEventController {

    @Autowired
    private AssetLifecycleEventService service;

    @PostMapping("/{assetId}")
    public AssetLifecycleEvent save(@PathVariable Long assetId,
                                   @RequestBody AssetLifecycleEvent event) {
        return service.saveEvent(assetId, event);
    }

    @GetMapping("/{assetId}")
    public List<AssetLifecycleEvent> getByAsset(@PathVariable Long assetId) {
        return service.getEventsByAsset(assetId);
    }
}
