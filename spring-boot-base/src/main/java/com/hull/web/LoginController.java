package com.hull.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登陆
 *
 * @author
 * @create 2018-03-22 下午5:01
 **/

@RestController
public class LoginController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    public ModelAndView toLogin() {
        logger.info("login");
        return view("login/login");
    }

    @RequestMapping("/{page}")
    public ModelAndView home(@PathVariable String page) {
        logger.info("login");
        return view("login/"+page);
    }
}
