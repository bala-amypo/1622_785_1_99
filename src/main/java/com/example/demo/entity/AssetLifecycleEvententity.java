package com.example.demo.entity;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Table(name = "asset_lifecycle_events")
public class AssetLifecycleEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String eventType;
    private String eventDescription;
    private LocalDate eventDate;
    private LocalDateTime loggedAt;

    public AssetLifecycleEvent() {
    }

    public AssetLifecycleEvent(Asset asset, String eventType, String eventDescription, LocalDate eventDate) {
        this.asset = asset;
        this.eventType = eventType;
        this.eventDescription = eventDescription;
        this.eventDate = eventDate;
        this.loggedAt = LocalDateTime.now();
    }

    // Getters and Setters
}
