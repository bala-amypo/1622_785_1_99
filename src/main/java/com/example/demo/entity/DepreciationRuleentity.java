package com.example.demo.entity;
import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepreciationRuleentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ruleName;
    private String method; 
    @Positive
    private Integer usefulLifeYears;
    @Positive
    private Double salvageValue;
    private LocalDateTime createdAt = LocalDateTime.now();
}
