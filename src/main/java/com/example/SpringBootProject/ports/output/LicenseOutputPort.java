package com.example.SpringBootProject.ports.output;

public interface LicenseOutputPort{
    boolean isLicenseValid(String pluginName, String licenseKey);
}