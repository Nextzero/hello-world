package springcloud.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CustomerController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @Autowired
    protected LoadBalancerClient loadBalancerClient;

    protected RestTemplate restTemplate  = new RestTemplate();

    @RequestMapping(value = "/customer" ,method = RequestMethod.GET)
    public String customer() {
        ServiceInstance choose = loadBalancerClient.choose("provider-demo");
        String url = "http://" + choose.getHost() + ":" + choose.getPort() + "/hello?from=CustomerDemo1";
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }
}