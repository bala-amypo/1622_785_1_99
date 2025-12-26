package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "depreciation_rules")
public class DepreciationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;
    private String method;
    private int usefulLifeYears;
    private double salvageValue;

    public Long getId() { return id; }
    public String getRuleName() { return ruleName; }
    public String getMethod() { return method; }
    public int getUsefulLifeYears() { return usefulLifeYears; }
    public double getSalvageValue() { return salvageValue; }

    public void setRuleName(String ruleName) { this.ruleName = ruleName; }
    public void setMethod(String method) { this.method = method; }
    public void setUsefulLifeYears(int usefulLifeYears) { this.usefulLifeYears = usefulLifeYears; }
    public void setSalvageValue(double salvageValue) { this.salvageValue = salvageValue; }
}
