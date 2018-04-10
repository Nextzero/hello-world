package springcloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CustomerDemo1 {

    public static void main(String[] args) {
        SpringApplication.run(CustomerDemo1.class, args);
    }
}
