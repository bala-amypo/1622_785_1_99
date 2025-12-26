package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vendors", uniqueConstraints = @UniqueConstraint(columnNames = "vendorName"))
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String vendorName;

    private String contactEmail;

    public Long getId() { return id; }
    public String getVendorName() { return vendorName; }
    public String getContactEmail() { return contactEmail; }

    public void setVendorName(String vendorName) { this.vendorName = vendorName; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }
}
