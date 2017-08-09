package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@Aspect
public class TestAop {

    @Before(value = "execution ( * com.example.controller..*.*(..)) && @annotation(requestMapping)")
    public void test(JoinPoint jp, RequestMapping requestMapping){
        System.out.println("这是是切面");
    }
}
