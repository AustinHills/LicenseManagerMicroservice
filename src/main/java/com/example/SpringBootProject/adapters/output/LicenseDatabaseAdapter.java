package com.example.SpringBootProject.adapters.output;

import com.example.SpringBootProject.ports.output.LicenseOutputPort;
import org.springframework.stereotype.Repository;

@Repository
public class LicenseDatabaseAdapter implements LicenseOutputPort {
    private final LicenseRepository licenseRepository;

    public LicenseDatabaseAdapter(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

    @Override
    public boolean isLicenseValid(String pluginName, String licenseKey) {
        return licenseRepository.existsByPluginNameAndLicenseKey(pluginName,licenseKey);
    }
}
