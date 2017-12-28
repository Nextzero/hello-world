package demo;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyServletRequestListener implements ServletRequestListener {

    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("requestDestroyed");
    }

    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("requestInitialized");
    }
}
