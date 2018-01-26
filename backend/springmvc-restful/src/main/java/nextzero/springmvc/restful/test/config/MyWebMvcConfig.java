package nextzero.springmvc.restful.test.config;

import nextzero.springmvc.restful.test.MyHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.List;

@Configuration
public class MyWebMvcConfig extends WebMvcConfigurationSupport {

    @Override
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        RequestMappingHandlerAdapter requestMappingHandlerAdapter = super.requestMappingHandlerAdapter();
        requestMappingHandlerAdapter.setOrder(0);
        return requestMappingHandlerAdapter;
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(getMyConverter());
    }

    @Bean
    @Order(0)
    public MyHttpMessageConverter getMyConverter() {
        return new MyHttpMessageConverter();
    }
}
