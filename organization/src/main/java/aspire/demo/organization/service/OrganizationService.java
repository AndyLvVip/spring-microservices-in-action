package aspire.demo.organization.service;

import aspire.demo.organization.domain.Organization;
import aspire.demo.organization.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public Organization getOrganization(String organizationId) {
        return organizationRepository.findByOrganizationId(organizationId);
    }

    public void edit(Organization organization) {
        organizationRepository.save(organization);
    }

    public void create(Organization organization) {
        organization.setOrganizationId(UUID.randomUUID().toString());
        organizationRepository.save(organization);
    }

    public void delete(Organization organization) {
        organizationRepository.delete(organization);
    }
}
