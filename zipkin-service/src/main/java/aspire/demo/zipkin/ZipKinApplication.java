package aspire.demo.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableEurekaClient
@RefreshScope
@EnableZipkinServer
public class ZipKinApplication {

    public static void main(String[] args) {

        SpringApplication.run(ZipKinApplication.class, args);

    }
}
