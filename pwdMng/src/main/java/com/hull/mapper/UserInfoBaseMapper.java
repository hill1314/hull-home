package com.hull.mapper;

import com.hull.common.BaseMapper;
import com.hull.entity.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
warning
This file is generated by CodeMonkey
Please DO NOT modify this file
**/

@Repository
public interface UserInfoBaseMapper extends BaseMapper<Long,UserInfo> {

    List<UserInfo> select(UserInfo userInfo);
}