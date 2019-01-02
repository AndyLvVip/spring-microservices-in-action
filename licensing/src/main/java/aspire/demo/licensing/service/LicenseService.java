package aspire.demo.licensing.service;

import aspire.demo.licensing.ServiceConfig;
import aspire.demo.licensing.clients.OrganizationRestTemplateClient;
import aspire.demo.licensing.domain.License;
import aspire.demo.licensing.repository.LicenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LicenseService {

    private final LicenseRepository licenseRepository;

    private final ServiceConfig serviceConfig;

    private final OrganizationRestTemplateClient organizationRestTemplateClient;

    public LicenseService(LicenseRepository licenseRepository,
                          ServiceConfig serviceConfig,
                          OrganizationRestTemplateClient organizationRestTemplateClient) {
        this.licenseRepository = licenseRepository;
        this.serviceConfig = serviceConfig;
        this.organizationRestTemplateClient = organizationRestTemplateClient;
    }

    public License getLicense(String licenseId) {
        License license = licenseRepository.findByLicenseId(licenseId);
        license.setOrganization(organizationRestTemplateClient.getOrganization(license.getOrganizationId()));
        license.setComment(serviceConfig.getExampleProperty());
        return license;
    }

    public List<License> getLicenseByOrg(String organizationId) {
        return licenseRepository.findByOrganizationId(organizationId);
    }

    public void create(License license) {
        license.setLicenseId(UUID.randomUUID().toString());
        licenseRepository.save(license);
    }

    public void edit(License license) {
        licenseRepository.save(license);
    }

    public void delete(License license) {
        licenseRepository.delete(license);
    }

}
