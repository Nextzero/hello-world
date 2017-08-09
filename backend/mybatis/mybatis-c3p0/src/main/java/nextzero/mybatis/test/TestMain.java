package nextzero.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class TestMain {

    public static void main(String[] args) throws Exception {
        PropertyConfigurator.configure("log4j.properties");

        String resource = "mybatis-config.xml";
        InputStream mybatisInputStream = new FileInputStream(resource);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(mybatisInputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            MysqlUserMapper mysqlUserMapper = sqlSession.getMapper(MysqlUserMapper.class);
            List<Map> userList = mysqlUserMapper.getUserList();
            System.out.println(userList);
            userList = mysqlUserMapper.getUserList();
            sqlSession.clearCache();
            userList = mysqlUserMapper.getUserList();
        }finally {
            if(null != sqlSession){
                sqlSession.close();
            }
        }
    }
}
