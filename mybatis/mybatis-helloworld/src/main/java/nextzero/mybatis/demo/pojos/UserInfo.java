package nextzero.mybatis.demo.pojos;

public class UserInfo {

    public int userId;
    public String userName;
    public int age;
    public String des;

    public int depId;

    public UserInfo(){

    }

    public UserInfo(int userId, String userName, int age, String des, int depId) {
        this.userId = userId;
        this.userName = userName;
        this.age = age;
        this.des = des;
        this.depId = depId;
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }


    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }


    public String getDes() {
        return des;
    }
    public void setDes(String des) {
        this.des = des;
    }

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", des='" + des + '\'' +
                ", depId=" + depId +
                '}';
    }
}