package com.example.demo.entity;
import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssetDisposalentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate disposalDate;
    private String disposalMethod;
    @Positive
    private Double disposalValue;
    private String approvedBy;
    private LocalDateTime createdat;
    @OneToOne
    @JoinColumn(name = "asset_id")
    private Assetentity asset;

}
