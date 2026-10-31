package com.example.SpringBootProject.adapters.output;

import com.example.SpringBootProject.ports.output.LicenseOutputPort;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Repository
@Data
@AllArgsConstructor
public class LicenseDatabaseAdapter implements LicenseOutputPort {
    private final LicenseRepository licenseRepository;

    @Override
    public boolean isLicenseValid(String pluginName, String licenseKey) {
        return licenseRepository.existsByPluginNameAndLicenseKey(pluginName,licenseKey);
    }
}
