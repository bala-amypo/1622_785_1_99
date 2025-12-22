package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assetentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String assetTag;
    @NotNull
    private String assetName;
    private Long vendorId; 
    private LocalDate purchaseDate;
    @Positive
    private Double purchaseCost;
    private Long depreciationRuleId; 
    private String status = "ACTIVE";
    private LocalDateTime createdAt = LocalDateTime.now();
}
