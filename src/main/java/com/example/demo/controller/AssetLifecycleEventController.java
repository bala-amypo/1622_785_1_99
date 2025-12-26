package com.example.demo.controller;

import com.example.demo.entity.AssetLifecycleEvent;
import com.example.demo.service.AssetLifecycleEventService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class AssetLifecycleEventController {
    private final AssetLifecycleEventService service;
    public AssetLifecycleEventController(AssetLifecycleEventService s) { this.service = s; }
    @PostMapping("/{id}") public AssetLifecycleEvent log(@PathVariable Long id, @RequestBody AssetLifecycleEvent e) { return service.logEvent(id, e); }
    @GetMapping("/asset/{id}") public List<AssetLifecycleEvent> list(@PathVariable Long id) { return service.getEventsForAsset(id); }
}