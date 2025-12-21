package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Assetentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
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
