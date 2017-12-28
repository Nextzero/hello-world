package nextzero.web.server.demo.controller;

import nextzero.web.server.demo.entity.ErrorType;
import nextzero.web.server.demo.util.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 当没有权限或未登陆时，跳转到该接口进行后续处理。
 */
@Controller
@RequestMapping("/reject")
@ApiIgnore
public class NoPermittedController {
    public static Logger LOG = LoggerFactory.getLogger(NoPermittedController.class);


    @RequestMapping(value = "unlogin", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object unlogin(){
        LOG.error("unlogin error");
       return ResponseUtils.fail(ErrorType.UNLOGIN_ERROR);
    }


    @RequestMapping(value = "unauthorization", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object unauthorization(){
        LOG.error("unauthorization error");
        return ResponseUtils.fail(ErrorType.UNAUNAUTHORIZATION_ERROR);
    }
}