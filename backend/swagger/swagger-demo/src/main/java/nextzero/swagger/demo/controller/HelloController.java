package nextzero.swagger.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import nextzero.swagger.demo.domain.BaseResponse;
import nextzero.swagger.demo.domain.PageRequest;
import nextzero.swagger.demo.domain.request.QueryUserList;
import nextzero.swagger.demo.domain.response.User;
import nextzero.swagger.demo.utils.ResponseUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hello")
@Api(description = "Hello管理")
public class HelloController {

    @RequestMapping(value = "/domi", method= RequestMethod.GET)
    @ResponseBody
    public BaseResponse hello(){
        return ResponseUtils.success();
    }
}
