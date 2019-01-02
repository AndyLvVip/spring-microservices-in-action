package aspire.demo.organization.controller;

import aspire.demo.organization.domain.Organization;
import aspire.demo.organization.service.OrganizationService;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrganizationController {

    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/organizations/{organizationId}")
    public Organization get(@PathVariable("organizationId") String organizationId) {
        return organizationService.getOrganization(organizationId);
    }

    @PutMapping("/organizations/{organizationId}")
    public void edit(@PathVariable("organizationId") String organizationId, @RequestBody Organization organization) {
        organizationService.edit(organization);
    }

    @DeleteMapping("/organizations/{organizationId}")
    public void delete(@PathVariable("organizationId") String organizationId, @RequestBody Organization organization) {
        organizationService.delete(organization);
    }

    @PostMapping("/organizations")
    public void create(@RequestBody Organization organization) {
        organizationService.create(organization);
    }

}
