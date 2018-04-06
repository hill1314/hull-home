package com.hull.controller;

import com.hull.dto.LoginDto;
import com.hull.dto.RespDto;
import com.hull.entity.StaffInfo;
import com.hull.service.StaffService;
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
    private StaffService staffService;

    /**
     * 用户登陆
     * @param name
     * @param pwd
     * @return
     */
    @RequestMapping("login")
//    public RespDto<StaffInfo> loginIn(@RequestBody LoginDto loginDto){
    public RespDto<StaffInfo> loginIn(String name, String pwd){
        if(name==null || pwd==null){
            return RespDto.error("参数为空");
        }
        StaffInfo staffInfo = staffService.getByNameAndPwd(name,pwd);
        if(staffInfo==null){
            return RespDto.error("用户名或密码错误");
        }
        return RespDto.success(staffInfo);
    }

    /**
     * 用户注册
     * @param staffInfo
     * @return
     */
    @RequestMapping("register")
    public RespDto<StaffInfo> register(@RequestBody StaffInfo staffInfo){
        if(staffInfo.getName()==null || staffInfo.getPassword()==null){
            return RespDto.error("用户名和密码不能为空");
        }
        int n = staffService.add(staffInfo);
        if(n==0){
            return RespDto.error("注册失败");
        }
        return RespDto.success(staffInfo);
    }

}
