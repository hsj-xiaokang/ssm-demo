数据库名称：ssm
数据库用到的表:user
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(50) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` int(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `userTemp` (
  `id` varchar(50) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` int(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



搭建该项目使用的博客：
http://blog.csdn.net/yezhuanxu/article/details/53483130
mybatis-generrator博客教程
http://blog.csdn.net/gebitan505/article/details/44455005/
自动生成mapper.xml解决追加问题
https://my.oschina.net/u/140938/blog/220006
对generatorMybatis配置文件的Context标签下，可以增加属性标签，名称为：mergeable；例如：
<property name="mergeable" value="false"></property>

1.如果是在eclipse 中，选择pom.xml文件，击右键先择Run AS——>Maven Build… ——>在Goals框中输入：mybatis-generator:generate 

2.如果在命令行输入Maven命令即可，注意：一定是当前项目目录下运行该命令：
     mvn mybatis-generator:generate



