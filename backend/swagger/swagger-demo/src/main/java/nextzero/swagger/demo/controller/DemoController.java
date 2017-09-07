package nextzero.swagger.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ResponseHeader;
import nextzero.swagger.demo.domain.BaseResponse;
import nextzero.swagger.demo.domain.response.User;
import nextzero.swagger.demo.utils.ResponseUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/demo")
@Api(value = "/user", description = "Operations about user")
public class DemoController {

    /**
     *
     * @return
     */
    @RequestMapping(value = "/get", method= RequestMethod.GET)
    @ApiOperation(
            value = "获取用户列表",
            notes = "F2",
            response = User.class)
    public BaseResponse getResponse(){
        User u1 = new User(1, "name-1", 12);
        User u2 = new User(2, "name-3", 13);
        List<User> result = new ArrayList<>();
        result.add(u1);
        result.add(u2);

        return ResponseUtils.success(result, 10);
    }


    @ApiOperation(
            value = "Find purchase order by ID",
            notes = "For valid response try integer IDs with value <= 5 or > 10. Other values will generated exceptions",
            response = User.class,
            responseContainer = "List",
            tags = {"Pet Store"})
    @ResponseHeader(name="head1",description="response head conf")
    @RequestMapping(value = "/get2222", method= RequestMethod.GET)
    public List<User> getResponse2222(){
        User u1 = new User(1, "name-1", 12);
        User u2 = new User(2, "name-3", 13);
        List<User> result = new ArrayList<>();
        result.add(u1);
        result.add(u2);

        return result;
    }


}
