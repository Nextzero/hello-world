package nextzero.web.server.demo.service;

import nextzero.web.server.demo.entity.BaseResponse;
import nextzero.web.server.demo.entity.BaseResponsePage;
import nextzero.web.server.demo.entity.PageRequest;
import nextzero.web.server.demo.entity.domain.Menu;
import nextzero.web.server.demo.entity.domain.UserCredentials;
import nextzero.web.server.demo.entity.params.sysadmin.*;
import nextzero.web.server.demo.entity.result.Role;
import nextzero.web.server.demo.entity.result.User;
import nextzero.web.server.demo.mapper.UserMapper;
import nextzero.web.server.demo.entity.ErrorType;
import nextzero.web.server.demo.util.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    public static Logger LOG = LoggerFactory.getLogger(UserService.class);
    private static final String DEFAULT_PWD = "123456";

    @Autowired
    protected UserMapper userMapper;

    /**
     * 查询用户账号密码等认证信息，若用户存在，则返回用户信息，若用户不存在，则返回null
     * @param userName
     * @return
     */
    public UserCredentials getUserCredentials(String userName) {
        UserCredentials userCredentials = userMapper.getUserCredentials(userName);
        return userCredentials;
    }

    /**
     * 查询用户接口权限集合
     * @param userName
     * @return
     */
    public List<String> getUserUrlPermissions(String userName){
        List<String> urlPermissions = userMapper.getUserUrlPermissions(userName);
        return urlPermissions;
    }

    /**
     * 查询用户可使用的菜单列表
     * @param userName
     * @return
     */
    public List<Menu> getUserMenu(String userName){
        List<Menu> userMenu = userMapper.getUserMenu(userName);
        //仅限两级菜单
        List<Menu> rootMenu = new ArrayList<>();
        for(Menu m : userMenu) {
            if(m.getParentId() == 0){
                rootMenu.add(m);
            }
        }

        for(int i=0; i<rootMenu.size(); i++){
            Menu parent = rootMenu.get(i);
            for(int j=0; j<userMenu.size(); j++){
                Menu child = userMenu.get(j);
                if(child.getParentId().equals(parent.getId())){
                    parent.addChild(child);
                }
            }
        }
        return rootMenu;
    }

    /**
     * 设置用户密码
     * @param username
     * @param newpwd
     */
    public void updateUserPwd(String username, String newpwd){
        Map<String, Object> daoRequest = new HashMap<>();
        daoRequest.put("username", username);
        daoRequest.put("newpwd", newpwd);
        userMapper.updateUserPwd(daoRequest);
    }

    /**
     * 新增用户
     * @param params
     * @return
     */
    @Transactional
    public BaseResponse addUser(AddUserParams params){
        params.setPassword(DEFAULT_PWD);
        try{
            userMapper.addUser(params);
            Map<String,Object> addRolesParams = new HashMap<>();
            addRolesParams.put("id", params.getId());
            addRolesParams.put("roles", params.getRoles());
            userMapper.addUserRoles(addRolesParams);
            return ResponseUtils.success();
        }catch (Exception e){
            LOG.error("", e);
        }

        return ResponseUtils.fail(ErrorType.INNER_ERROR);
    }

    /**
     * 检查用户名是否存在
     * @param username
     * @return
     */
    public BaseResponse checkUsername(String username){
        UserCredentials userCredentials = userMapper.getUserCredentials(username);
        if(null == userCredentials){
            LOG.warn("用户名已存在：" + username);
            return ResponseUtils.fail(ErrorType.USERNAME_EXIST);
        }

        return ResponseUtils.success();
    }

    /**
     * 删除用户
     * @param params
     * @return
     */
    @Transactional
    public BaseResponse delUser(DelUserParams params){
        userMapper.delUser(params.getUserIds());
        userMapper.delUserRoles(params.getUserIds());
        return ResponseUtils.success();
    }

    @Transactional
    public BaseResponse updateUser(UpdateUserParams params){
        userMapper.updateUser(params);

        List<Integer> user = new ArrayList<>();
        user.add(params.getId());
        userMapper.delUserRoles(user);

        Map<String,Object> addRolesParams = new HashMap<>();
        addRolesParams.put("id", params.getId());
        addRolesParams.put("roles", params.getRoles());
        userMapper.addUserRoles(addRolesParams);

        return ResponseUtils.success();
    }

    public BaseResponsePage<User> listUser(PageRequest<ListUserParams> params){
        long total = userMapper.countUser(params.getParams());
        List<User> userList = null;
        if(total > 0 ){
            userList = userMapper.listUser(params);
        }else{
            userList = new ArrayList<>();
        }
        return ResponseUtils.success(total, userList);
    }

    public BaseResponse resetPasswrod(ResetPwdParams params){
        updateUserPwd(params.getUsername(), DEFAULT_PWD);
        return ResponseUtils.success();
    }

    /**
     * 枚举系统内所有可用角色
     * @return
     */
    public BaseResponsePage<Role> listRoles(){
        List<Role> roles = userMapper.listRoles();
        return ResponseUtils.success(roles.size(), roles);
    }
}
