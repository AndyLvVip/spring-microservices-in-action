package aspire.demo.licensing.repository;

import aspire.demo.licensing.domain.License;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LicenseRepository extends CrudRepository<License, String> {

    List<License> findByOrganizationId(String organizationId);


    License findByLicenseId(String licenseId);
}
