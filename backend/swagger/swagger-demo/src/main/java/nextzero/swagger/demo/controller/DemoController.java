package nextzero.swagger.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nextzero.swagger.demo.domain.BaseResponse;
import nextzero.swagger.demo.utils.ResponseUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@Api("这是DemoController")
public class DemoController {

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value = "/get", method= RequestMethod.GET)
    public BaseResponse getResponse(){
        return ResponseUtils.success();
    }
}
