package demo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContentLister implements ServletContextListener{

    public MyServletContentLister() {
        System.out.println("MyServletContentLister 构造函数");
    }

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized");

        sce.getServletContext().addListener(new MyServletRequestListener());
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed");
    }
}
