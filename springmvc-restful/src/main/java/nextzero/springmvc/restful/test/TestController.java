package nextzero.springmvc.restful.test;

import nextzero.springmvc.restful.test.dao.UserDao;
import nextzero.springmvc.restful.test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    protected UserDao userDao;

    @RequestMapping(value = "/getuser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User getUser(@RequestParam(value = "id") String id){
        User user = new User();
        user.setUserId("my user id json");
        user.setUserName("my user name");
        return user;
    }

    @RequestMapping(value = "/getuserxml", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public User getUserXml(@RequestParam(value = "id") String id){
        User user = new User();
        user.setUserId("my user id xml");
        user.setUserName("my user name");
        return user;
    }

    @RequestMapping(value = "/postuser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User postUser(@RequestBody User user){
        System.out.println("postUser:" + user);
        return user;
    }

    @RequestMapping(value = "/postuserxml", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public User postUserXml(@RequestBody User user){
        System.out.println("postUserXml:" + user);
        return user;
    }

    //================================================================================================================
    //结合mybatis测试
    @RequestMapping(value = "/db/getuser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User getUserFromDB(@RequestParam(value = "id") String id){
        System.out.println("getUserFromDB:" + id);
        return userDao.getUserById(id);
    }

    @RequestMapping(value = "/db/getuserlist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<User> getUserListFromDB(){
        System.out.println("getUserFromDBList");
        List<User> userList = userDao.getUserList();
        return userList;
    }
}
