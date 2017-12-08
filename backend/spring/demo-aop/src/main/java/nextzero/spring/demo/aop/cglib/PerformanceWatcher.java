package nextzero.spring.demo.aop.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class PerformanceWatcher implements MethodInterceptor {

	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
        //模拟性能测试
        long begin = System.currentTimeMillis();

        /**
         * 不可像JDK代理那样来调用，否则将会造成循环调用
         * Object result = method.invoke(obj, args);
         */
		Object result=proxy.invokeSuper(obj, args);

        //模拟性能测试
        System.out.println(method.getName() + ": " + (System.currentTimeMillis() - begin));
        return result;
	}
}
