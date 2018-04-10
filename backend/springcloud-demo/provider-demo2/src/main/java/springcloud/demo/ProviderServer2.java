package springcloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProviderServer2 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderServer2.class, args);
    }
}
