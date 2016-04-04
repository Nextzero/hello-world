package nextzero.spring.demo.aop.jdk;

import nextzero.spring.demo.aop.BusinessImp;
import nextzero.spring.demo.aop.IBusiness;

import java.lang.reflect.Proxy;


/**
 * 测试JDK动态代理技术
 * 测试接口IBusiness
 */
public class TestJDKProxy {

    public static void main(String[] args){
        //正常业务执行对象
        IBusiness user = new BusinessImp();

        //模拟性能监控对象，对业务对象的每一个方法调用进行监控
        //通过构造函数，将业务对象传递进去
        //性能监控类必须实现InvocationHandler接口
        PerformanceWatcher watcher = new PerformanceWatcher(user);

        //通过JDK Proxy类，动态创建一个代理类
        //该动态类，实现了业务类的所有接口
        IBusiness proxy = (IBusiness)Proxy.newProxyInstance(user.getClass().getClassLoader(),new Class[]{IBusiness.class}, watcher);

        //像使用业务对象一样使用代理对像，他们有一样的接口
        proxy.commitNewUser("czhc", "123456");
        proxy.hello("czhc");
    }
}
