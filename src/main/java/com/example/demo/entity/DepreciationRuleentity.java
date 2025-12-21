package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepreciationRuleentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String ruleName;

    @Column(nullable = false)
    private String method; // STRAIGHT_LINE / DECLINING_BALANCE

    @Column(nullable = false)
    private Integer usefulLifeYears;

    @Column(nullable = false)
    private Double salvageValue;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
