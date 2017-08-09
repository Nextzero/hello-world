package nextzero.cxf.test;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

public class ServerMain {

    public static void main(String[] args) {
        JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
        sf.setResourceClasses(UserService.class);
        sf.setServiceBean(new UserService());
        sf.setAddress("http://localhost:9999/");
        sf.create();
    }
}
