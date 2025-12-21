package com.example.demo.controller;

import com.example.demo.entity.AssetLifecycleEvententity;
import com.example.demo.service.AssetLifecycleEventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class AssetLifecycleEventController {
@Autowired
    private  AssetLifecycleEventService eventService;

    public AssetLifecycleEventController(AssetLifecycleEventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public AssetLifecycleEvententity saveEvent(@RequestBody AssetLifecycleEvententity event) {
        return eventService.saveEvent(event);
    }

    @GetMapping
    public List<AssetLifecycleEvententity> getAllEvents() {
        return eventService.getAllEvents();
    }
}
