package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    protected Sender sender;

    @RequestMapping(value = "/customer" ,method = RequestMethod.GET)
    public String customer() {
        sender.send();
        return "ok";
    }
}