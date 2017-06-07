package nextzero.spring.demo.aop.spring;


/**
 * 服务生抽象接口
 * 假设服务生只干两件事
 * 第一，欢迎顾客
 * 第二，对顾客提供服务
 */
public interface Waiter {

    /**
     * 欢迎顾客
     * @param name 顾客姓名
     */
    void greetTo(String name);


    /**
     * 对顾客提供服务
     * @param name
     * @throws Exception
     */
    void serveTo(String name) throws Exception;
}
