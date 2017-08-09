package nextzero.spring.demo.aop.spring.advice2;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @ApsectJ切点表达式函数
 * 方法切点函数
 * 方法入参切点函数
 * 目标类切点函数
 * 代理类切点函数
 *
 */
@Aspect
public class GreetingAdvice2 {

    @Before(value = "execution (* nextzero.spring.demo.aop.spring.NaiveWaiter.greetTo(..))")
    protected void before(JoinPoint jp){
        System.out.println("这里是切面");
    }
}
