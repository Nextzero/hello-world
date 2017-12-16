package nextzero.swagger.demo.controller;

import io.swagger.annotations.*;
import nextzero.swagger.demo.domain.BaseResponse;
import nextzero.swagger.demo.domain.BaseResponsePage;
import nextzero.swagger.demo.domain.PageRequest;
import nextzero.swagger.demo.domain.request.QueryUserList;
import nextzero.swagger.demo.domain.response.User;
import nextzero.swagger.demo.utils.ResponseUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api(value = "用户", description = "用户管理",consumes="application/json, application/xml")
public class UserController {


    /**
     * 场景：分页请求列表数据
     * 请求：PageRequest<QueryUserList>
     * 响应：BaseResponsePage，其中data=List<User>
     * @return
     */
    @ApiOperation(
            value = "获取用户列表",
            notes = "通过部门名称，查询部门下的用户列表，分页； 部门名称模糊匹配。",
            response = User.class,
            responseContainer = "List")
    @ApiResponses({
            @ApiResponse(code = 0, message = "定义HTTP错误码", response = BaseResponsePage.class)
    })
    @ApiImplicitParams({
            //用于描述请求字段说明
            @ApiImplicitParam(paramType="header",name="username",dataType="String",required=true,value="用户的姓名",defaultValue="zhaojigang"),
            @ApiImplicitParam(paramType="query",name="password",dataType="String",required=true,value="用户的密码",defaultValue="wangna"),
            @ApiImplicitParam(paramType="body",name="list",dataType="String",required=true,value="33333333",defaultValue="wangna")
    })
    @ApiModelProperty(value = "name", name = "name", dataType = "double")
    @RequestMapping(value = "/list", method= RequestMethod.GET,
            produces= MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public BaseResponse list(@RequestBody PageRequest<QueryUserList> request){

        User u1 = new User(1, "name-1", 12);
        User u2 = new User(2, "name-3", 13);
        List<User> result = new ArrayList<>();
        result.add(u1);
        result.add(u2);

        return ResponseUtils.success(result, 10);
    }


    @RequestMapping(value = "/list2", method= RequestMethod.GET,
            produces= MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Updated user", notes = "This can only be done by the logged in user.")
    public BaseResponse updateUser(
            @ApiParam(value = "name that need to be updated", required = true) @PathParam("username") String username,
            @ApiParam(value = "Updated user object", required = true) User user) {
        return null;
    }

}
