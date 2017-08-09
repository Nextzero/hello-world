package nextzero.spring.demo.aop.spring.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 服务生前置增强
 * 让他们在打招呼和提供服务之前，都必须对顾客使用礼貌用语
 *
 * 方法前置增强，需要实现接口MethodBeforeAdvice
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        String name = (String)objects[0];
        System.out.println("How are you!" + name);
        //并不需要手动调用实际业务对象！！！！
    }
}
