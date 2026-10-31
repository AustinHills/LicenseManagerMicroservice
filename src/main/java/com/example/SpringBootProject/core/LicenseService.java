package com.example.SpringBootProject.core;

import com.example.SpringBootProject.core.models.LicenseRequest;
import com.example.SpringBootProject.core.models.LicenseResponse;
import com.example.SpringBootProject.ports.output.LicenseOutputPort;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class LicenseService {

    final private LicenseOutputPort licenseOutputPort;

    public LicenseResponse verify(LicenseRequest licenseRequest){
        LicenseResponse response = new LicenseResponse();
        response.setUpdateAvailable(false);

        boolean isValid = licenseOutputPort.isLicenseValid(licenseRequest.getPluginName(), licenseRequest.getLicenseKey());

        if(isValid){
            response.setStatus("ACTIVE");
        }else{
            response.setStatus(("INACTIVE"));
        }

        return response;
    }
}
