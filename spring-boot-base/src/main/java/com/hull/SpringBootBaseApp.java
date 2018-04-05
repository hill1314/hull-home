package com.hull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring boot base
 *
 * @author
 * @create 2018-03-22 下午3:59
 **/

@RestController
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.hull"})
public class SpringBootBaseApp {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(SpringBootBaseApp.class,args);
    }

}
