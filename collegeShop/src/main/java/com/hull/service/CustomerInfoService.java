package com.hull.service;

import com.hull.entity.CustomerInfo;
import com.hull.mapper.CustomerInfoBaseMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 客户信息服务
 *
 * @author
 * @create 2018-04-21 上午8:49
 **/
@Service
public class CustomerInfoService {
    @Resource
    private CustomerInfoBaseMapper customerInfoBaseMapper;


    public CustomerInfo getByNameAndPwd(String name, String pwd) {
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setName(name);
        customerInfo.setPassword(pwd);
        List<CustomerInfo> customerInfoList = customerInfoBaseMapper.select(customerInfo);
        if(CollectionUtils.isEmpty(customerInfoList)){
            return null;
        }
        return customerInfoList.get(0);
    }

    public List<CustomerInfo> select(CustomerInfo customerInfo) {
        List<CustomerInfo> customerInfoList = customerInfoBaseMapper.select(customerInfo);
        return customerInfoList;
    }

    public int add(CustomerInfo customerInfo) {
        return customerInfoBaseMapper.add(customerInfo);
    }

    public int update(CustomerInfo customerInfo) {
        return customerInfoBaseMapper.updateIgnoreNull(customerInfo);
    }
}
