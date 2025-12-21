package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssetLifecycleEvententity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long assetId; // storing assetId instead of relationship

    @Column(nullable = false)
    private String eventType;

    @Column(nullable = false)
    private String eventDescription;

    @Column(nullable = false)
    private LocalDate eventDate;

    @Column(nullable = false)
    private LocalDateTime loggedAt = LocalDateTime.now();
}
