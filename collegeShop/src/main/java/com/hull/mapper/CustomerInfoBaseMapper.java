package com.hull.mapper;

import com.hull.common.BaseMapper;
import com.hull.entity.CustomerInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
warning
This file is generated by CodeMonkey
Please DO NOT modify this file
**/
@Repository
public interface CustomerInfoBaseMapper extends BaseMapper<Long,CustomerInfo> {

    List<CustomerInfo> select(CustomerInfo customerInfo);
}