package nextzero.web.server.demo.controller;

import nextzero.web.server.demo.entity.BaseResponsePage;
import nextzero.web.server.demo.entity.result.Role;
import nextzero.web.server.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sysadmin/role")
@Api(description = "角色")
public class RoleController {

    @Autowired
    protected UserService userService;

    @ApiOperation(
            value = "查询系统内所有可用的角色列表",
            notes = "管理员在新增或编辑用户角色时，可通过该接口获取系统内所有可用的角色列表")
    @RequestMapping(value = "list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponsePage<Role> list(){
        return userService.listRoles();
    }
}
