package com.hull.dto;

import com.hull.common.BaseEntity;

/**
 * 登陆认证信息
 *
 * @author
 * @create 2018-04-05 下午2:30
 **/

public class LoginDto extends BaseEntity{
    /**
     姓名
     **/
    private String name;
    /**
     密码
     **/
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
