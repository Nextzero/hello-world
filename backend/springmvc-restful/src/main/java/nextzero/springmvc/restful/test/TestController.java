package nextzero.springmvc.restful.test;

import nextzero.springmvc.restful.test.entity.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {

    @RequestMapping(value = "/getuser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User getUser(@RequestParam(value = "id") String id){
        User user = new User();
        user.setUserId("my user id json");
        user.setUserName("my user name");
        return user;
    }

    @RequestMapping(value = "/postuser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User postUser(@RequestBody User user){
        System.out.println("postUser:" + user);
        return user;
    }

    @RequestMapping(value = "/mypost", method = RequestMethod.POST,  produces = { "application/x-czhc" },  consumes = { "application/x-czhc" })
    @ResponseBody
    public User mypost(@RequestBody User user){
        System.out.println("postUser:" + user);
        return user;
    }
}
