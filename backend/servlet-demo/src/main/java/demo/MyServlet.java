package demo;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class MyServlet implements Servlet{

    public MyServlet() {
        System.out.println("MyServlet 构造函数");
    }

    public void init(ServletConfig config) throws ServletException {
        System.out.println("MyServlet init");
        String value = config.getInitParameter("myInitKey");
        System.out.println(value);
        Enumeration<String> initParameterNames = config.getInitParameterNames();
        while(initParameterNames.hasMoreElements()){
            String next = initParameterNames.nextElement();
            System.out.println(next);
            System.out.println(config.getInitParameter(next));
        }

        String contextConfigLocation = config.getServletContext().getInitParameter("contextConfigLocation");
        System.out.println(contextConfigLocation);
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
