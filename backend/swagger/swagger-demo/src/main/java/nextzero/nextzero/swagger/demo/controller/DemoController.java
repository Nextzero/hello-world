package nextzero.nextzero.swagger.demo.controller;

import nextzero.nextzero.swagger.demo.domain.BaseResponse;
import nextzero.nextzero.swagger.demo.utils.ResponseUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @RequestMapping(value = "/get", method= RequestMethod.GET)
    public BaseResponse getResponse(){
        return ResponseUtils.success();
    }
}
