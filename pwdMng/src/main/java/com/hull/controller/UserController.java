package com.hull.controller;

import com.hull.entity.RespDto;
import com.hull.entity.UserInfo;
import com.hull.service.UserService;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户管理
 *
 * @author
 * @create 2018-05-05 下午2:31
 **/

@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("list")
    public RespDto<List<UserInfo>> list(@RequestBody UserInfo userInfo){
        List<UserInfo> userInfoList = userService.find(userInfo);
        return RespDto.success(userInfoList);
    }

    @RequestMapping("register")
    public RespDto<UserInfo> registerUser(@RequestBody UserInfo userInfo){
        if(StringUtils.isEmpty(userInfo.getName()) || StringUtils.isEmpty(userInfo.getPassword())){
            return RespDto.error("用户名和密码不能为空");
        }
        int n = userService.add(userInfo);
        if(n==0){
            return RespDto.error("添加失败");
        }
        return RespDto.success(userInfo);
    }

    @RequestMapping("login")
    public RespDto<UserInfo> login(String name ,String pwd){
        if(StringUtils.isEmpty(name) || StringUtils.isEmpty(pwd)){
            return RespDto.error("参数为空");
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setName(name);
        userInfo.setPassword(pwd);
        List<UserInfo> list = userService.find(userInfo);
        if(CollectionUtils.isEmpty(list)){
            return RespDto.error("用户名或密码错误");
        }
        return RespDto.success(list.get(0));
    }

    @RequestMapping("modify")
    public RespDto<UserInfo> modify(@RequestBody UserInfo userInfo){
        if(StringUtils.isEmpty(userInfo.getId())){
            return RespDto.error("主键为空");
        }
        int n = userService.update(userInfo);
        if(n==0){
            return RespDto.error("修改失败");
        }
        return RespDto.success(userInfo);
    }

    @RequestMapping("del/{id}")
    public RespDto<UserInfo> del(@PathVariable Long id){
        if(StringUtils.isEmpty(id)){
            return RespDto.error("主键为空");
        }
        int n = userService.del(id);
        if(n==0){
            return RespDto.error("删除失败");
        }
        return RespDto.success();
    }
}
