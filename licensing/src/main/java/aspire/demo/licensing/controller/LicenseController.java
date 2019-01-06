package aspire.demo.licensing.controller;

import aspire.demo.licensing.domain.License;
import aspire.demo.licensing.service.LicenseService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class LicenseController {

    private LicenseService licenseService;

    public LicenseController(LicenseService licenseService) {
        this.licenseService = licenseService;
    }

    @GetMapping("/licenses/{licenseId}")
    @PreAuthorize("@financeMenu.canDelete(authentication)")
    public License getLicense(@PathVariable("licenseId") String licenseId) {
        return licenseService.getLicense(licenseId);
    }

    @PostMapping("/licenses")
    public void create(@RequestBody License license) {
        licenseService.create(license);
    }

    @PutMapping("/licenses/{licenseId}")
    public void edit(@PathVariable("licenseId") String licenseId, @RequestBody License license) {
        licenseService.edit(license);
    }

    @DeleteMapping("/license/{licenseId}")
    public void delete(@PathVariable("licenseId") String licenseId, @RequestBody License license) {
        licenseService.delete(license);
    }

}
