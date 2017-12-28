package nextzero.web.server.demo.mapper;

import nextzero.web.server.demo.entity.PageRequest;
import nextzero.web.server.demo.entity.domain.Menu;
import nextzero.web.server.demo.entity.domain.UserCredentials;
import nextzero.web.server.demo.entity.params.sysadmin.AddUserParams;
import nextzero.web.server.demo.entity.params.sysadmin.ListUserParams;
import nextzero.web.server.demo.entity.params.sysadmin.UpdateUserParams;
import nextzero.web.server.demo.entity.result.Role;
import nextzero.web.server.demo.entity.result.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    UserCredentials getUserCredentials(String userName);

    List<String> getUserUrlPermissions(String userName);

    List<Menu> getUserMenu(String userName);

    /**
     *
     * @param params
     * {
     *     username: '123',
     *     newpwd:'123456'
     * }
     */
    void updateUserPwd(Map params);

    void addUser(AddUserParams params);

    /**
     *
     * @param params
     * {
     *     id: 1,
     *     roles:[
     *     1,2,3
     *     ]
     * }
     */
    void addUserRoles(Map<String,Object> params);

    void delUser(List<Integer> userIds);

    void delUserRoles(List<Integer> userIds);

    void updateUser(UpdateUserParams params);

    long countUser(ListUserParams params);

    List<User> listUser(PageRequest<ListUserParams> params);

    List<Role> listRoles();
}
