package com.hull.service;

import com.hull.entity.UserInfo;
import com.hull.mapper.UserInfoBaseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户管理
 *
 * @author
 * @create 2018-05-05 下午2:21
 **/
@Service
public class UserService {
    @Resource
    private UserInfoBaseMapper userInfoMapper;

    /**
     * 查找
     * @param userInfo
     * @return
     */
    public List<UserInfo> find(UserInfo userInfo){
        return userInfoMapper.select(userInfo);
    }

    /**
     * 增
     * @param userInfo
     * @return
     */
    public int add(UserInfo userInfo){
        return userInfoMapper.add(userInfo);
    }

    /**
     * 删
     * @param id
     * @return
     */
    public int del(Long id){
        return userInfoMapper.delete(id);
    }

    /**
     * 改
     * @param userInfo
     * @return
     */
    public int update(UserInfo userInfo){
        return userInfoMapper.updateIgnoreNull(userInfo);
    }

}
