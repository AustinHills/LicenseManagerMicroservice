package com.example.SpringBootProject.adapters.output;

import jakarta.persistence.*;

@Entity
@Table(name="licenses")
public class LicenseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String pluginName;

    String licenseKey;
}
