## 0 项目运行基本环境要求
需要在本地安装  mysql 、jdk-1.8、 maven 

## 1 在本地安装 mysql 数据库 （数据库连接工具建议用 Navicat ）
（1）新建一个新的数据库 ： pwd_mng (可以自定义为别的)

（2）在数据库中创建表 ：student_score  
```sql
CREATE TABLE `student_score` (
  `student_id` varchar(32) NOT NULL COMMENT '学号',
  `student_name` varchar(32) DEFAULT NULL COMMENT '姓名',
  `total_score` int(11) DEFAULT NULL COMMENT '总分',
  `lesson_num` int(11) DEFAULT NULL COMMENT '门数',
  `sex` varchar(4) DEFAULT NULL COMMENT '性别',
  `total_credit` int(11) DEFAULT NULL COMMENT '总学分',
  `average_credit` int(11) DEFAULT NULL COMMENT '学分加权平均分',
  `ranking` int(11) DEFAULT NULL COMMENT '班级排名',
  `term_no` varchar(16) DEFAULT NULL COMMENT '学期',
  `english_1` int(11) DEFAULT NULL COMMENT '大学英语（一）',
  `english_2` int(11) DEFAULT NULL COMMENT '大学英语（二）',
  `english_3` int(11) DEFAULT NULL COMMENT '大学英语（三）',
  `math_1_1` int(11) DEFAULT NULL COMMENT '高数1-1',
  `math_1_2` int(11) DEFAULT NULL COMMENT '高数1-2',
  `linear_math` int(11) DEFAULT NULL COMMENT '线性代数',
  `language_design` int(11) DEFAULT NULL COMMENT '高级语言程序设计 ',
  `language_design_test` int(11) DEFAULT NULL COMMENT '高级语言程序设计实验 ',
  `object_language_design` int(11) DEFAULT NULL COMMENT '面向对象程序设计 ',
  `language_design_train` int(11) DEFAULT NULL COMMENT '程序设计训练 ',
  `digital_systerm_design` int(11) DEFAULT NULL COMMENT '数字系统与逻辑设计 ',
  `digital_systerm_design_test` int(11) DEFAULT NULL COMMENT '数字系统与逻辑设计实验 ',
  `moral_and_law` int(11) DEFAULT NULL COMMENT '思想道德修养与法律基础 ',
  `chinese_history` int(11) DEFAULT NULL COMMENT '中国近现代史纲要 ',
  `max_theory` int(11) DEFAULT NULL COMMENT '马克思主义基本原理概论 ',
  `sports` int(11) DEFAULT NULL COMMENT '体育1 ',
  `profession_plan` int(11) DEFAULT NULL COMMENT '大学生职业生涯规划 ',
  `mind_health` int(11) DEFAULT NULL COMMENT '大学生心理健康 ',
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
```

## 2 导入项目
（1） 将 scoresMng.zip 解压

（2）打开IDEA 或 eclipse 将 解压后的工程源码导入

（3）修改 工程代码中的 application.properties 文件中的数据源，改为本地的mysql地址、用户名、密码
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/pwd_mng?characterEncoding=utf8
spring.datasource.username=root
spring.datasource.password=123123

```
（4）打开项目中的 SSMApplication.java ，右键运行 main 方法 即可启动
