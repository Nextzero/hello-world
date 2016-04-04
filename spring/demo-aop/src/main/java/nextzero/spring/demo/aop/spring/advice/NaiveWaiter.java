package nextzero.spring.demo.aop.spring.advice;


/**
 * 一个训练不足的服务生
 * 只是简单的向顾客打招呼，闷不作声地走到顾客面前
 * 其服务用语不够热情
 */
public class NaiveWaiter implements Waiter{

    @Override
    public void greetTo(String name) {
        System.out.println("greet to " + name + "...");
    }

    @Override
    public void serveTo(String name) throws Exception{
        System.out.println("serving " + name + "...");
    }
}
