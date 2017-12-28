package nextzero.web.server.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
@ComponentScan
public class StartupMain {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(StartupMain.class);
        Set<Object> set = new HashSet<Object>();
        set.add("classpath:applicationContext.xml");
        app.setSources(set);
        app.run(args);
    }
}
