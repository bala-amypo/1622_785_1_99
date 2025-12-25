package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "asset_lifecycle_events")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssetLifecycleEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Asset asset;

    @NotBlank
    private String eventType;

    private LocalDate eventDate;

    private String remarks;
}
