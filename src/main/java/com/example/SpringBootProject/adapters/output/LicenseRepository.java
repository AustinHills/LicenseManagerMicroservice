package com.example.SpringBootProject.adapters.output;

import org.springframework.data.repository.CrudRepository;

public interface LicenseRepository extends CrudRepository<LicenseEntity, Long> {
    boolean existsByPluginNameAndLicenseKey(String pluginName, String licenseKey);
}
