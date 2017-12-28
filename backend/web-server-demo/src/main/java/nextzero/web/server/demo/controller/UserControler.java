package nextzero.web.server.demo.controller;

import nextzero.web.server.demo.entity.BaseResponse;
import nextzero.web.server.demo.entity.BaseResponsePage;
import nextzero.web.server.demo.entity.PageRequest;
import nextzero.web.server.demo.entity.params.sysadmin.*;
import nextzero.web.server.demo.entity.result.User;
import nextzero.web.server.demo.service.UserService;
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
@RequestMapping("/sysadmin/user")
@Api(description = "用户")
public class UserControler {

    @Autowired
    protected UserService userService;


    @ApiOperation(
            value = "检查用户名是否存在",
            notes = "管理员新增用户时，可通过该接口检查输入的用户名是否已存在")
    @RequestMapping(value = "check", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse checkUsername(@RequestBody CheckUsernameParams request){
        return userService.checkUsername(request.getUsername());
    }


    @ApiOperation(
            value = "新增用户",
            notes = "")
    @RequestMapping(value = "add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse add(@RequestBody AddUserParams request){
        return userService.addUser(request);
    }

    @ApiOperation(
            value = "删除用户",
            notes = "")
    @RequestMapping(value = "del", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse del(@RequestBody DelUserParams params){
        return userService.delUser(params);
    }

    @ApiOperation(
            value = "更新用户",
            notes = "")
    @RequestMapping(value = "update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse update(@RequestBody UpdateUserParams request){
        return userService.updateUser(request);
    }

    @ApiOperation(
            value = "查询用户列表",
            notes = "支持分页")
    @RequestMapping(value = "list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponsePage<User> list(@RequestBody PageRequest<ListUserParams> request){
        return userService.listUser(request);
    }

    @ApiOperation(
            value = "管理员重置用户密码",
            notes = "")
    @RequestMapping(value = "resetpwd", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse resetpwd( @RequestBody ResetPwdParams params){
        return userService.resetPasswrod(params);
    }
}
