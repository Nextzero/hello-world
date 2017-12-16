package nextzero.spring.demo.aop.cglib2;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import nextzero.spring.demo.aop.BusinessImp;


/**
 * 测试CGLib动态代理技术
 * 基于JDK的动态代理技术，只能为接口创建代理实例
 * 而CGLib技术，通过创建子类，并在子类中拦截方法调用
 */
public class TestCGLibMain2 {

    public static void main(String[] args){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(BusinessImp.class);
        enhancer.setCallbacks(new Callback[]{new CommitUserInterceptor(), new HelloInterceptor()});
        enhancer.setCallbackFilter(new MyCallbackFilter());
        BusinessImp proxy = (BusinessImp)enhancer.create();

        System.out.println(proxy.getClass().getName());
        proxy.commitNewUser("czhc","123456");
        proxy.hello("caaa");
    }
}
