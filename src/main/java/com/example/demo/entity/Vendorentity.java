package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "Vendor name must not be blank")
    @Column(nullable = false, unique = true)
    private String vendorName;

    @NotBlank(message = "Contact email must not be blank")
    @Email(message = "Contact email must be a valid email address")
    @Column(nullable = false)
    private String contactEmail;

    @Column
    private String phone;

    @Column(nullable = false)
    private LocalDateTime createdAt;
}
