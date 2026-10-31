package com.example.SpringBootProject.adapters.input;

import com.example.SpringBootProject.core.LicenseService;
import com.example.SpringBootProject.core.models.LicenseRequest;
import com.example.SpringBootProject.core.models.LicenseResponse;
import com.example.SpringBootProject.ports.input.ApiApi;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LicenseController implements ApiApi {

    private final LicenseService licenseService;


    public LicenseController(LicenseService licenseService) {
        this.licenseService = licenseService;
    }

    @Override
    public ResponseEntity<LicenseResponse> verifyLicense(LicenseRequest licenseRequest) {
        LicenseResponse response = licenseService.verify(licenseRequest);

        return ResponseEntity.ok(response);
    }
}
