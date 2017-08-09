package nextzero.cxf.test;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="user")
public class User {
    String id;
    String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}