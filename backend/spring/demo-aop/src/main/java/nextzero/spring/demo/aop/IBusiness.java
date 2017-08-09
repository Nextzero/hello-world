package nextzero.spring.demo.aop;

/**
 * 模拟业务接口
 * 用于各种AOP技术的测试借口
 */
public interface IBusiness {

    public String commitNewUser(String user, String pwd);


    public String hello(String time);
}
