package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class AssetLifecycleEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventType;
    private String description;
    private LocalDate eventDate;

    @ManyToOne
    private Asset asset;

    public Long getId() { return id; }
    public String getEventType() { return eventType; }
    public String getDescription() { return description; }
    public LocalDate getEventDate() { return eventDate; }
    public Asset getAsset() { return asset; }

    public void setEventType(String eventType) { this.eventType = eventType; }
    public void setDescription(String description) { this.description = description; }
    public void setEventDate(LocalDate eventDate) { this.eventDate = eventDate; }
    public void setAsset(Asset asset) { this.asset = asset; }
}
