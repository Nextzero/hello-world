package nextzero.spring.demo.aop.spring.advice;

import nextzero.spring.demo.aop.spring.advice.GreetingBeforeAdvice;
import nextzero.spring.demo.aop.spring.advice.NaiveWaiter;
import nextzero.spring.demo.aop.spring.advice.Waiter;
import org.springframework.aop.AfterAdvice;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * 前置增强
 * 后置增强
 * 环绕增强
 * 异常抛出增强
 * 引介增强
 *
 * Spring Proxy实际上使用的就是JDK动态代理或者Cglib动态代理技术
 *
 */
public class ZTestSpringAdvice {

    public static void main(String[] args){
        //一个训练不足的服务生对象
        Waiter target = new NaiveWaiter();

        //前置增强，在服务前加上礼貌用语
        BeforeAdvice beforeAdvice = new GreetingBeforeAdvice();

        //后置增强，在服务后加上礼貌用语
        AfterAdvice afterAdvice = new GreetingAfterAdvice();

        //spring提供的代理工厂
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);

        //多个adivce，按添加顺序执行
        pf.addAdvice(beforeAdvice);
        pf.addAdvice(afterAdvice);

        //动态产生代理对象
        Waiter proxy = (Waiter)pf.getProxy();
        try {
            proxy.serveTo("czhc");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
