package com.hull.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @author
 * @create 2019-04-29 17:54
 **/

@RestController
public class HomeController {

    @RequestMapping("/home")
    public String home(){
        return "success";
    }
}
