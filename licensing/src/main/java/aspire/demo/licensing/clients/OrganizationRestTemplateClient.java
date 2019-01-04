package aspire.demo.licensing.clients;

import aspire.demo.licensing.domain.Organization;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OrganizationRestTemplateClient {
    public final RestTemplate restTemplate;

    public OrganizationRestTemplateClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(threadPoolKey = "get-organization-by-id")
    public Organization getOrganization(String organizationId) {
        return restTemplate.exchange(
                "http://ZUUL/organizationservice/organizations/{organizationId}",
                HttpMethod.GET,
                null,
                Organization.class,
                organizationId
        ).getBody();
    }
}
