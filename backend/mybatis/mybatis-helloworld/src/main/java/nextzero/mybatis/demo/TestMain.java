package nextzero.mybatis.demo;

import nextzero.mybatis.demo.dao.SystemInfoMapper;
import nextzero.mybatis.demo.pojos.DepInfo;
import nextzero.mybatis.demo.pojos.UserInfo;
import org.apache.ibatis.ognl.IntHashMap;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.ObjectInput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMain {

    public static void main(String[] args) throws Exception {
        /**
         * 从 XML 中构建 SqlSessionFactory
         *
         * 每个基于 MyBatis 的应用都是以一个 SqlSessionFactory 的实例为中心的。
         * SqlSessionFactory 的实例可以通过 SqlSessionFactoryBuilder 获得。
         * 而 SqlSessionFactoryBuilder 则可以从 XML 配置文件或一个预先定制的
         * Configuration 的实例构建出 SqlSessionFactory 的实例。
         *
         */
        FileInputStream confInputStream = new FileInputStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(confInputStream);

        /**
         * 从 SqlSessionFactory 中获取 SqlSession
         */
        SqlSession session = factory.openSession(true);

        try {
            SystemInfoMapper mapper = session.getMapper(SystemInfoMapper.class);
            final int rootId = 9999;
            DepInfo depRoot = new DepInfo(rootId,"总坛",rootId);
            DepInfo dep1 = new DepInfo(1,"广州分舵",rootId);
            DepInfo dep2 = new DepInfo(2,"长沙分舵",rootId);
            DepInfo dep3 = new DepInfo(3,"多余的分舵",rootId);

            //插入部门
            mapper.addDep(depRoot);
            mapper.addDep(dep1);
            mapper.addDep(dep2 );
            mapper.addDep(dep3);

             //修改部门
            dep3.setDepName("多余的部门2");
            mapper.updateDepInfo(dep3);

             //删除部门
            mapper.deleteDep(3);

            UserInfo user1 = new UserInfo(1,"张1",1,"hello",1);
            UserInfo user2 = new UserInfo(2,"张2",1,"hello",1);
            UserInfo user3 = new UserInfo(3,"张3",1,"hello",1);
            UserInfo user4 = new UserInfo(4,"张4",1,"hello",2);
            UserInfo user5 = new UserInfo(5,"多余的人",1,"hello",2);

            //插入用户
            mapper.addUser(user1);
            mapper.addUser(user2);
            mapper.addUser(user3);
            mapper.addUser(user4);
            mapper.addUser(user5);

            //修改用户信息
            user5.setUserName("多余的人2");
            mapper.updateUserInfo(user5);

            //删除用户
            mapper.deleteUser(5);

            //查询
            DepInfo depById = mapper.getDepById(1);
            System.out.println(depById);

            List<UserInfo> userList = mapper.getUserByDepId(1);
            System.out.println(userList);

            Map<String,Object> req = new HashMap<String,Object>();
            req.put("name","张1");
            List<UserInfo> userByNameAndAge = mapper.getUserByNameAndAge(req);
            System.out.println(userByNameAndAge);
        }catch (Exception e){
            e.printStackTrace();
        } finally{
            if(null != session){
                session.close();
            }
        }
    }
}
