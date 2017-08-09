package nextzero.springmvc.restful.test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestConfig {


    @Value("#{configProperties['test.name']}")
    protected String name;

    @Value("#{configProperties['test.version']}")
    protected String version;

    @PostConstruct
    public void init(){
        System.out.println("TestConfig构造后，调用该方法进行初始化");
        System.out.println(name);
        System.out.println(version);
    }
}
