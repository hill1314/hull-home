package com.hull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class MDBApplication {

    public static void main(String[] args){
        SpringApplication.run(MDBApplication.class,args);
    }

    @RequestMapping("/")
    public String init(){
        return "Welcome to collage-shop-system!";
    }

}
