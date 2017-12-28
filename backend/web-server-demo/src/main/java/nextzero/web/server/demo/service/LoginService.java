package nextzero.web.server.demo.service;

import nextzero.web.server.demo.entity.BaseResponse;
import nextzero.web.server.demo.entity.domain.UserCredentials;
import nextzero.web.server.demo.entity.params.sysadmin.ModifyPwdParams;
import nextzero.web.server.demo.entity.result.LoginResult;
import nextzero.web.server.demo.security.SessionUtil;
import nextzero.web.server.demo.entity.ErrorType;
import nextzero.web.server.demo.util.ResponseUtils;
import nextzero.web.server.demo.entity.params.sysadmin.LoginParams;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public static Logger LOG = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    protected UserService userService;

    public BaseResponse<LoginResult> login(LoginParams login){
        String userName = login.getUsername();
        String password = login.getPassword();

        try {
            //STEP 1: 使用shiro完成登陆验证，当验证失败将抛出异常
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
            subject.login(token);

            //STEP 2: 更新登录日志,登录时间
            SessionUtil.refreshSessionTime();

            //STEP 3: 读取用户相关信息 - 用户基本信息，菜单
            LoginResult info = new LoginResult();
            info.setMenuList(userService.getUserMenu(userName));
            return ResponseUtils.success(info);
        } catch (Exception e) {
            //ERROR: 忽略错误细节，直接打印错误
            //LOG.error("", e);
            SessionUtil.setCurUser(null);
        }
        return ResponseUtils.fail(ErrorType.LOGIN_ERROR);
    }

    public BaseResponse logout(){
        Subject subject = SecurityUtils.getSubject();
        SessionUtil.setCurUser(null);
        subject.logout();
        return ResponseUtils.success();
    }

    public BaseResponse modifypwd(ModifyPwdParams params){
        UserCredentials curUser = SessionUtil.getCurUser();//里面没有密码了
        if(null == curUser){
            return ResponseUtils.fail(ErrorType.UNLOGIN_ERROR);
        }
        UserCredentials userCredentials = userService.getUserCredentials(curUser.getUsername());
        if(!userCredentials.getPassword().equals(params.getOldpwd())){
            LOG.error("old pwd error:{}", params);
            return ResponseUtils.fail(ErrorType.OLDPWD_ERROR);
        }
        userService.updateUserPwd(curUser.getUsername(), params.getNewpwd());
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ResponseUtils.success();
    }

    public BaseResponse checkLoginStatus(){
        UserCredentials curUser = SessionUtil.getCurUser();
        if(null == curUser){
            return ResponseUtils.fail(ErrorType.UNLOGIN_ERROR);
        }
        LoginResult info = new LoginResult();
        info.setMenuList(userService.getUserMenu(curUser.getUsername()));
        return ResponseUtils.success(info);
    }

    public UserCredentials getCurUser(){
        UserCredentials curUser = SessionUtil.getCurUser();
        if(null == curUser){
            LOG.error("curUser为null");
        }
        return curUser;
    }
}
