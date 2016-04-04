package nextzero.spring.demo.aop;


import java.util.Date;

/**
 * 模拟业务实现
 * 用于各种AOP技术测试
 */
public class BusinessImp implements IBusiness {

    @Override
    public String commitNewUser(String user, String pwd) {

        System.out.println("commit new user: user=" + user + "  pwd=" + pwd);
        try {
            Thread.currentThread().sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "test string";
    }


    @Override
    public String hello(String time) {

        return new Date().toString();
    }
}
