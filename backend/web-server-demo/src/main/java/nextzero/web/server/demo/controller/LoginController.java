package nextzero.web.server.demo.controller;

import nextzero.web.server.demo.entity.BaseResponse;
import nextzero.web.server.demo.entity.params.sysadmin.ModifyPwdParams;
import nextzero.web.server.demo.entity.result.LoginResult;
import nextzero.web.server.demo.service.LoginService;
import nextzero.web.server.demo.entity.params.sysadmin.LoginParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("sysadmin")
@Api(description = "登陆")
public class LoginController {

    @Autowired
    protected LoginService loginService;

    @ApiOperation(
            value = "用户登陆",
            notes = "")
    @RequestMapping(value = "login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse<LoginResult> login(@RequestBody LoginParams request){
        return loginService.login(request);
    }

    @ApiOperation(
            value = "用户登出",
            notes = "",
            response = BaseResponse.class)
    @RequestMapping(value = "logout", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse logout(){
        return loginService.logout();
    }


    @ApiOperation(
            value = "用户修改密码",
            notes = "先校验当前用户是否登陆，然后判断旧密码是否正确，都满足后才执行密码修改",
            response = BaseResponse.class)
    @RequestMapping(value = "modifypwd", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse modifypwd(@RequestBody ModifyPwdParams request){
        return loginService.modifypwd(request);
    }

    @ApiOperation(
            value = "校验当前登陆状态",
            notes = "",
            response = BaseResponse.class)
    @RequestMapping(value = "checkloginstatus", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse checkLoginStatus(){
        return loginService.checkLoginStatus();
    }
}
