package com.example.demo.controller;

import com.example.demo.entity.AssetLifecycleEvent;
import com.example.demo.service.AssetLifecycleEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class AssetLifecycleEventController {
    @Autowired private AssetLifecycleEventService service;

    @PostMapping("/{assetId}")
    public AssetLifecycleEvent log(@PathVariable Long assetId, @RequestBody AssetLifecycleEvent e) {
        return service.logEvent(assetId, e);
    }

    @GetMapping("/asset/{assetId}")
    public List<AssetLifecycleEvent> get(@PathVariable Long assetId) {
        return service.getEventsForAsset(assetId);
    }
}