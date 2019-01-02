package aspire.demo.organization.repository;

import aspire.demo.organization.domain.Organization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, String> {

    Organization findByOrganizationId(String organizationId);
}
