package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepreciationRuleentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Rule name must not be blank")
    @Column(nullable = false, unique = true)
    private String ruleName;

    @NotBlank(message = "Method must not be blank")
    @Column(nullable = false)
    private String method;

    @Min(value = 1, message = "Useful life years must be greater than 0")
    @Column(nullable = false)
    private Integer usefulLifeYears;

    @Min(value = 0, message = "Salvage value must be greater than or equal to 0")
    @Column(nullable = false)
    private Double salvageValue;

    @Column(nullable = false)
    private LocalDateTime createdAt;
}
