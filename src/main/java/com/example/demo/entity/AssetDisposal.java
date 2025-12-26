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

    public Long getId() { return id; }
    public String getDisposalMethod() { return disposalMethod; }
    public double getDisposalValue() { return disposalValue; }
    public LocalDate getDisposalDate() { return disposalDate; }
    public Asset getAsset() { return asset; }

    public void setDisposalMethod(String disposalMethod) { this.disposalMethod = disposalMethod; }
    public void setDisposalValue(double disposalValue) { this.disposalValue = disposalValue; }
    public void setDisposalDate(LocalDate disposalDate) { this.disposalDate = disposalDate; }
    public void setAsset(Asset asset) { this.asset = asset; }
}
