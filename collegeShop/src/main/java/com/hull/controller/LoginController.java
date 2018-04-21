package com.hull.controller;

import com.hull.dto.RespDto;
import com.hull.entity.CustomerInfo;
import com.hull.service.CustomerInfoService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 登陆、注册
 *
 * @author
 * @create 2018-04-05 上午5:40
 **/
@RestController
@RequestMapping("system")
public class LoginController {

    @Resource
    private CustomerInfoService customerInfoService;

    /**
     * 用户登陆
     * @param name
     * @param pwd
     * @return
     */
    @RequestMapping("login")
    public RespDto<CustomerInfo> loginIn(String name, String pwd){
        if(name==null || pwd==null){
            return RespDto.error("参数为空");
        }
        CustomerInfo customerInfo = customerInfoService.getByNameAndPwd(name,pwd);
        if(customerInfo==null){
            return RespDto.error("用户名或密码错误");
        }
        return RespDto.success(customerInfo);
    }

    /**
     * 用户注册
     * @param customerInfo
     * @return
     */
    @RequestMapping("register")
    public RespDto<CustomerInfo> register(@RequestBody CustomerInfo customerInfo){
        if(customerInfo.getName()==null || customerInfo.getPassword()==null){
            return RespDto.error("用户名和密码不能为空");
        }
        int n = customerInfoService.add(customerInfo);
        if(n==0){
            return RespDto.error("注册失败");
        }
        return RespDto.success(customerInfo);
    }

}
