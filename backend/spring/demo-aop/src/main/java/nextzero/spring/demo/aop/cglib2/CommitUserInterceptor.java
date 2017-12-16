package nextzero.spring.demo.aop.cglib2;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CommitUserInterceptor implements MethodInterceptor {

	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {

		System.out.println("这里是CommitUserInterceptor，仅对commitNewUser方法进行拦截");
		Object result=proxy.invokeSuper(obj, args);
        return result;
	}
}
