package com.hull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @author
 * @create 2019-04-29 17:52
 **/

@RestController
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.hull"})
public class MyActivityApplication {

    public static void main(String[] args){
        SpringApplication.run(MyActivityApplication.class,args);
    }

    @RequestMapping("/")
    public String init(){
        return "Welcome to collage-shop-system!";
    }

}
