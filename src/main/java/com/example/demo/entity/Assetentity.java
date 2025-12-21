package com.example.demo.entity;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
@Entity
@Table(name = "assets")
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String assetTag;
    private String assetName;
    private LocalDate purchaseDate;
    private Double purchaseCost;
    private String status; // ACTIVE, MAINTENANCE, DISPOSED
    private LocalDateTime createdAt;

    @OneToOne(mappedBy = "asset")
    private AssetDisposal disposal;

    public Asset() {
    }

    public Asset(String assetTag, String assetName, LocalDate purchaseDate, Double purchaseCost) {
        this.assetTag = assetTag;
        this.assetName = assetName;
        this.purchaseDate = purchaseDate;
        this.purchaseCost = purchaseCost;
        this.status = "ACTIVE";
        this.createdAt = LocalDateTime.now();
    }
}
