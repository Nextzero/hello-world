Spring + Spring MVC + Mybatis

CREATE DATABASE `test` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `user` (
  `userId` int(11) NOT NULL,
  `userName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
