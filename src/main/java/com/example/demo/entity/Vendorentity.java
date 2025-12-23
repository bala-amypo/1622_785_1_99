package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vendorentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Vendor name must not be Null")
    @Column(nullable = false, unique = true)
    private String vendorName;
    @NotNull(message = "Contact email must not be Null")
    @Email(message = "Contact email must be a valid email address")
    private String contactEmail;
    private String phone;
    @Column(nullable = false)
    private LocalDateTime createdAt;
}
