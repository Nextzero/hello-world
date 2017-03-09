场景：
    用户，部门的增删查改
类型：
    非spring的mybatis示例
SQL:

CREATE DATABASE `test_mybatis` /*!40100 DEFAULT CHARACTER SET utf8 */;


CREATE TABLE `dep` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `parent_dep_id` int(11) DEFAULT '9999',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `age` int(11) DEFAULT '0',
  `des` varchar(45) DEFAULT NULL,
  `dep_id` int(11) DEFAULT '9999',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


注意：
若是maven工程，则需要在pom.xml中加入一下内容
<build>
    <resources>
        <resource>
            <directory>src/main/java</directory>
            <includes>
                <include>**/*.xml</include>
            </includes>
            <filtering>true</filtering>
        </resource>
    </resources>
</build>