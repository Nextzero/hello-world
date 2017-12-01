package nextzero.spring.demo.aop.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {
	private Enhancer enhancer = new Enhancer();

    /**
     * 设置父类，回调接口，并动态创建子类
     * @param clazz
     * @return
     */
	public Object getProxy(Class clazz) {
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		return enhancer.create();
	}


    /**
     * 在动态创建的子类中，当任一个方法被调用时，将通过setCallback
     * 设置的回调接口将被调用。
     * @param obj
     * @param method
     * @param args
     * @param proxy
     * @return
     * @throws Throwable
     */
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
        //模拟执行性能监控逻辑
        System.out.println("begin....");
        System.out.println(method.getName());
        System.out.println(obj.getClass().getName());

        /**
         * 不可像JDK代理那样来调用，否则将会造成循环调用
         * Object result = method.invoke(obj, args);
         */
		Object result=proxy.invokeSuper(obj, args);

        //模拟执行性能监控逻辑
        System.out.println("end.....");
        return result;
	}
}
