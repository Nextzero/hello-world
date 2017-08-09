package nextzero.spring.demo.aop.spring.advice2;

import nextzero.spring.demo.aop.spring.NaiveWaiter;
import nextzero.spring.demo.aop.spring.Waiter;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * 基于@AspectJ注解的切面
 */
public class ZTestSpringAdvice2 {

    public static void main(String[] args){
        //一个训练不足的服务生对象
        Waiter target = new NaiveWaiter();

        AspectJProxyFactory factory = new AspectJProxyFactory();
        factory.setTarget(target);
        factory.addAspect(GreetingAdvice2.class);

        //动态产生代理对象
        Waiter proxy = (Waiter)factory.getProxy();
        try {
            proxy.greetTo("czhc");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
