package com.example.controller;


import com.example.domain.User;
import com.example.domain.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public Map<String, String> getInfos(){
        Map<String, String> map = new HashMap<>();
        map.put("a", "b");
        map.put("1", "2");
        return map;
    }

    @RequestMapping(value = "/getuserlist", method = RequestMethod.GET)
    public List<User> getUserList(){
        return userMapper.getUserList();
    }
}
