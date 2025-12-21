
package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AssetDisposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate disposalDate;

    private String disposalReason;

    /* One-to-One relationship with Asset (as per source) */
    @OneToOne
    @JoinColumn(name = "asset_id")
    private Asset asset;

    /* Kept simple to avoid User relationship issues */
    private String approvedBy;
}
