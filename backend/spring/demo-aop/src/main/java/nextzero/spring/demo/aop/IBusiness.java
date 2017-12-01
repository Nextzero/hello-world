package nextzero.spring.demo.aop;

/**
 * 模拟业务接口
 * 用于各种AOP技术的测试借口
 */
public interface IBusiness {

    String commitNewUser(String user, String pwd);


    String hello(String time);
}
