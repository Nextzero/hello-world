package nextzero.spring.demo.aop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 模拟性能监控对象，对业务对象的每一个方法调用进行监控
 * 通过构造函数，将业务对象传递进去
 * 性能监控类必须实现InvocationHandler接口
 */
public class PerformanceWatcher implements InvocationHandler{

    private Object target;
    public PerformanceWatcher(Object target){
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //模拟性能测试
        long begin = System.currentTimeMillis();

        //通过反射调用业务对象的相应方法
        Object obj = method.invoke(target, args);

        //模拟性能测试
        System.out.println(method.getName() + ": " + (System.currentTimeMillis() - begin));
        return obj;
    }
}
