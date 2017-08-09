package nextzero.springmvc.restful.test.dao;

import nextzero.springmvc.restful.test.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    List<User> getUserList();

    User getUserById(String userId);
}
