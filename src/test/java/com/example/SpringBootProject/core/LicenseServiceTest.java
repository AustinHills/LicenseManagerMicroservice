package com.example.SpringBootProject.core;

import com.example.SpringBootProject.core.models.LicenseRequest;
import com.example.SpringBootProject.core.models.LicenseResponse;
import com.example.SpringBootProject.ports.output.LicenseOutputPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LicenseServiceTest {
    @Mock
    private LicenseOutputPort licenseOutputPort;

    @InjectMocks
    private LicenseService licenseService;

    @Test
    public void testValidLicense(){
        String dummyName = "Pitchblade";
        String dummyLicenseKey = "1234-5678";

        LicenseRequest licenseRequest = new LicenseRequest();
        licenseRequest.setPluginName(dummyName);
        licenseRequest.setLicenseKey(dummyLicenseKey);

        Mockito.when(licenseOutputPort.isLicenseValid(dummyName,dummyLicenseKey)).thenReturn(true);

        LicenseResponse licenseResponse = licenseService.verify(licenseRequest);

        Assertions.assertEquals("ACTIVE",licenseResponse.getStatus());
        Assertions.assertFalse(licenseResponse.getUpdateAvailable());
        Mockito.verify(licenseOutputPort,Mockito.times(1)).isLicenseValid(dummyName,dummyLicenseKey);
        Mockito.verifyNoMoreInteractions(licenseOutputPort);
    }

    @Test
    public void testInvalidLicense(){
        String dummyName = "Pitchblade";
        String dummyLicenseKey = "1234-5678";

        LicenseRequest licenseRequest = new LicenseRequest();
        licenseRequest.setPluginName(dummyName);
        licenseRequest.setLicenseKey(dummyLicenseKey);

        Mockito.when(licenseOutputPort.isLicenseValid(dummyName,dummyLicenseKey)).thenReturn(false);

        LicenseResponse licenseResponse = licenseService.verify(licenseRequest);

        Assertions.assertEquals("INACTIVE",licenseResponse.getStatus());
        Assertions.assertFalse(licenseResponse.getUpdateAvailable());
        Mockito.verify(licenseOutputPort,Mockito.times(1)).isLicenseValid(dummyName,dummyLicenseKey);
        Mockito.verifyNoMoreInteractions(licenseOutputPort);
    }
}
