package nextzero.mybatis.demo.dao;


import nextzero.mybatis.demo.pojos.DepInfo;
import nextzero.mybatis.demo.pojos.UserInfo;

import java.util.List;
import java.util.Map;

public interface SystemInfoMapper {

    /**
     * 部门简单的增删查改
     */
    void addDep(DepInfo dep);

    void deleteDep(int depId);

    DepInfo getDepById(int depId);

    void updateDepInfo(DepInfo dep);


    /**
     * 用户简单的增删查改
     */
    void addUser(UserInfo info);

    void deleteUser(int userId);

    UserInfo getUserById(int userId);

    void updateUserInfo(UserInfo user);


    /**
     * 其他操作
     */
    //获取部门下所有用户
    List<UserInfo> getUserByDepId(int depId);
    //根据姓名和年龄查询用户
    List<UserInfo> getUserByNameAndAge(Map<String, Object> infos);
}
