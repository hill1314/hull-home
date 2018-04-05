package com.hull.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据源配置
 *
 * @author
 * @create 2018-04-05 上午8:01
 **/

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"com.hull.mapper"}, sqlSessionFactoryRef = "mySqlSessionFactory")
public class MybatisConfig {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${spring.datasource.driver-class-name}")
    private String driverName;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @Bean("myDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource myDataSource() throws Exception {
        logger.info("init salary DataSource!");
        Map<String, Object> map = new HashMap<>();
        map.put("url", myDataSourceProperties().getUrl());
        map.put("driverClassName", myDataSourceProperties().getDriverClassName());
        map.put("username", myDataSourceProperties().getUsername());
        map.put("password", myDataSourceProperties().getPassword());
        map.put("initialSize", "5");
        map.put("maxActive", "20");
        map.put("maxWait", "60000");
        map.put("timeBetweenEvictionRunsMillis", "60000");
        map.put("validationQuery", "SELECT 'x'");
        map.put("testWhileIdle", "true");
        map.put("testOnBorrow", "false");
        map.put("testOnReturn", "false");
        map.put("poolPreparedStatements", "false");
        DataSource dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(map);
        return dataSource;
    }

    @Bean("myDataSourceProperties")
    @ConfigurationProperties("spring.datasource")
    @Primary
    public DataSourceProperties myDataSourceProperties() {
        DataSourceProperties dataSource = new DataSourceProperties();
        dataSource.setDriverClassName(driverName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean("mySqlSessionFactory")
    @Primary
    public SqlSessionFactory mySqlSessionFactory(@Qualifier("myDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactory sqlSessionFactory = null;
        try {
            logger.info("init salary MyBatis sqlSessionFactory!");
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();

            sessionFactory.setDataSource(dataSource);
            sessionFactory.setMapperLocations(resolver.getResources("classpath:/mapper/**/*Mapper.xml"));
            sqlSessionFactory = sessionFactory.getObject();
        } catch (Exception e) {
            logger.error("fail to init MyBatis sqlSessionFactory!", e);
        }
        return sqlSessionFactory;
    }

    @Bean("transactionManager")
    public PlatformTransactionManager transactionManager() throws Exception {
        return new DataSourceTransactionManager(myDataSource());
    }
}
