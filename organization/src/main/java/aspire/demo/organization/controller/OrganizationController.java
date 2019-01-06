package aspire.demo.organization.controller;

import aspire.demo.organization.domain.Organization;
import aspire.demo.organization.service.OrganizationService;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class OrganizationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationController.class);

    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/organizations/{organizationId}")
    public Organization get(@PathVariable("organizationId") String organizationId, @AuthenticationPrincipal Authentication authentication) throws IOException {
        LOGGER.info("get-organization-authentication->" + new ObjectMapper().writeValueAsString(authentication));
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
