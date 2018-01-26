package nextzero.springmvc.restful.test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;

import javax.annotation.PostConstruct;

@Component
public class TestConfig {


    @Value("#{configProperties['test.name']}")
    protected String name;

    @Value("#{configProperties['test.version']}")
    protected String version;

    @PostConstruct
    public void init(){
        WebMvcConfigurerAdapter adapter;
        RequestMappingInfo a ;
        System.out.println("TestConfig构造后，调用该方法进行初始化");
        System.out.println(name);
        System.out.println(version);
    }
}
