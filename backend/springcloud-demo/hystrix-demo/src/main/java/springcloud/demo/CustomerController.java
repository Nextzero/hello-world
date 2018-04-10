package springcloud.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CustomerController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/customer")
    @HystrixCommand(fallbackMethod = "fallback")
    public String customer() {
        return restTemplate.getForObject("http://provider-demo/hello?from=hystrixdemo", String.class);
    }

    public String fallback() {
        return "fallback";
    }
}
