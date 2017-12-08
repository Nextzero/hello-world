package nextzero.spring.demo.aop.cglib2;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

public class MyCallbackFilter implements CallbackFilter {

    /**
     * 当通过Enhancer.setCallbacks方法指定了多个MethodInterceptor时，
     * 通过该方法来决定，每个方法调用哪个MethodInterceptor来拦截
     * 返回的值是MethodInterceptor数组的下标
     * @param method
     * @return
     */
    public int accept(Method method) {
        if(method.getName().equals("commitNewUser")){
            return 0;
        }else{
            return 1;
        }
    }
}
