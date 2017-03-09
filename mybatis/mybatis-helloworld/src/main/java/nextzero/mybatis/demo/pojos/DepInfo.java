package nextzero.mybatis.demo.pojos;

import java.util.List;

public class DepInfo {

    protected int depId;
    protected String depName;
    protected int parentDepId;
    protected List<UserInfo> userList;

    public DepInfo() {
    }

    public DepInfo(int depId, String depName, int parentDepId) {
        this.depId = depId;
        this.depName = depName;
        this.parentDepId = parentDepId;
    }

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public int getParentDepId() {
        return parentDepId;
    }

    public void setParentDepId(int parentDepId) {
        this.parentDepId = parentDepId;
    }

    public List<UserInfo> getUserList() {
        return userList;
    }

    public void setUserList(List<UserInfo> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "DepInfo{" +
                "depId=" + depId +
                ", depName='" + depName + '\'' +
                ", parentDepId=" + parentDepId +
                '}';
    }
}