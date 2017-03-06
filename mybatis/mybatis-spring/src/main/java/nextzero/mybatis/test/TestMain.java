package nextzero.mybatis.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;
import java.util.Map;

public class TestMain {

    @Autowired
    protected MysqlUserMapper user;

    public void test(){
        List<Map> userList = user.getUserList();
        System.out.println(userList);
    }

    public static void main(String[] args) {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("classpath:application-spring.xml");
        context.start();

        TestMain test = (TestMain)context.getBean("test");
        test.test();
    }
}
