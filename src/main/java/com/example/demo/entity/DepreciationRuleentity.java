package com.example.demo.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
@Entity
public class DepreciationRuleentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String ruleName;
    private String method; // STRAIGHT_LINE / DECLINING_BALANCE
    private Integer usefulLifeYears;
    private Double salvageValue;
    private LocalDateTime createdAt;

    public DepreciationRuleentity() {
    }

    public DepreciationRuleentity(String ruleName, String method, Integer usefulLifeYears, Double salvageValue) {
        this.ruleName = ruleName;
        this.method = method;
        this.usefulLifeYears = usefulLifeYears;
        this.salvageValue = salvageValue;
        this.createdAt = LocalDateTime.now();
    }
}
