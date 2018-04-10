package springcloud.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello" ,method = RequestMethod.GET)
    public String hello(@RequestParam String from) {
        ServiceInstance instance = client.getLocalServiceInstance();
        return "请求来源：" + from + "\n响应节点： Port:"+instance.getPort();
    }

    @RequestMapping(value = "/info" ,method = RequestMethod.GET)
    public String info() {
        ServiceInstance instance = client.getLocalServiceInstance();
        return "响应节点： Port:"+instance.getPort();
    }
}