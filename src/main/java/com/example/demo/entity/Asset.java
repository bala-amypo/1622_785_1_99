package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "assets", uniqueConstraints = @UniqueConstraint(columnNames = "assetTag"))
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String assetTag;
    private String assetName;
    private LocalDate purchaseDate;
    private double purchaseCost;
    private String status = "ACTIVE";

    @ManyToOne
    private Vendor vendor;

    @ManyToOne
    private DepreciationRule depreciationRule;

    public Long getId() { return id; }
    public String getAssetTag() { return assetTag; }
    public String getAssetName() { return assetName; }
    public LocalDate getPurchaseDate() { return purchaseDate; }
    public double getPurchaseCost() { return purchaseCost; }
    public String getStatus() { return status; }
    public Vendor getVendor() { return vendor; }
    public DepreciationRule getDepreciationRule() { return depreciationRule; }

    public void setAssetTag(String assetTag) { this.assetTag = assetTag; }
    public void setAssetName(String assetName) { this.assetName = assetName; }
    public void setPurchaseDate(LocalDate purchaseDate) { this.purchaseDate = purchaseDate; }
    public void setPurchaseCost(double purchaseCost) { this.purchaseCost = purchaseCost; }
    public void setStatus(String status) { this.status = status; }
    public void setVendor(Vendor vendor) { this.vendor = vendor; }
    public void setDepreciationRule(DepreciationRule depreciationRule) { this.depreciationRule = depreciationRule; }
}
