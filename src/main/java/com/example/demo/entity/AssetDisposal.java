package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class AssetDisposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String disposalMethod;
    private double disposalValue;
    private LocalDate disposalDate;

    @ManyToOne
    private Asset asset;

    @ManyToOne
    private User approvedBy;

    public Long getId() { return id; }
    public Asset getAsset() { return asset; }
    public User getApprovedBy() { return approvedBy; }

    public void setAsset(Asset asset) { this.asset = asset; }
    public void setApprovedBy(User approvedBy) { this.approvedBy = approvedBy; }
    public void setDisposalMethod(String disposalMethod) { this.disposalMethod = disposalMethod; }
    public void setDisposalValue(double disposalValue) { this.disposalValue = disposalValue; }
    public void setDisposalDate(LocalDate disposalDate) { this.disposalDate = disposalDate; }
}
