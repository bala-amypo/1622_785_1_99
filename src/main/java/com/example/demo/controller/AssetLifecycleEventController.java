package com.example.demo.controller;

import com.example.demo.entity.AssetLifecycleEvententity;
import com.example.demo.service.AssetLifecycleEventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class AssetLifecycleEventController {

    private final AssetLifecycleEventService eventService;

    public AssetLifecycleEventController(AssetLifecycleEventService eventService) {
        this.eventService = eventService;
    }

    // CREATE
    @PostMapping
    public AssetLifecycleEvent saveEvent(@RequestBody AssetLifecycleEvent event) {
        return eventService.saveEvent(event);
    }

    // READ ALL
    @GetMapping
    public List<AssetLifecycleEvent> getAllEvents() {
        return eventService.getAllEvents();
    }
}
