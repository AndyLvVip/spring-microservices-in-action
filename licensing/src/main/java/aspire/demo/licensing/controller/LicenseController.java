package aspire.demo.licensing.controller;

import aspire.demo.licensing.domain.License;
import aspire.demo.licensing.service.LicenseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LicenseController {

    private LicenseService licenseService;

    public LicenseController(LicenseService licenseService) {
        this.licenseService = licenseService;
    }

    @GetMapping("/license/{licenseId}")
    public License getLicense(@PathVariable("licenseId") String licenseId) {
        return licenseService.getLicense(licenseId);
    }

}
