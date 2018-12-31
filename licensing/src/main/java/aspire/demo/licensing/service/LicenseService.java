package aspire.demo.licensing.service;

import aspire.demo.licensing.ServiceConfig;
import aspire.demo.licensing.domain.License;
import aspire.demo.licensing.repository.LicenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LicenseService {

    private LicenseRepository licenseRepository;

    private ServiceConfig serviceConfig;

    public LicenseService(LicenseRepository licenseRepository,
                          ServiceConfig serviceConfig) {
        this.licenseRepository = licenseRepository;
        this.serviceConfig = serviceConfig;
    }

    public License getLicense(String licenseId) {
        License license = licenseRepository.findByLicenseId(licenseId);
        license.setProductName(serviceConfig.getExampleProperty());
        return license;
    }

    public List<License> getLicenseByOrg(String organizationId) {
        return licenseRepository.findByOrganizationId(organizationId);
    }

    public void save(License license) {
        license.setLicenseId(UUID.randomUUID().toString());
        licenseRepository.save(license);
    }

}
