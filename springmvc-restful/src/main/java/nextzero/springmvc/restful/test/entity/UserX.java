package nextzero.springmvc.restful.test.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserX {
    protected String userId;
    protected String userName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserX{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
