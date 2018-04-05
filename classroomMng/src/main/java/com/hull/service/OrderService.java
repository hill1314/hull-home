package com.hull.service;

import com.hull.entity.ClassOrderInfo;
import com.hull.mapper.ClassOrderInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单相关服务
 *
 * @author
 * @create 2018-04-05 上午6:26
 **/

@Service
public class OrderService {
    @Resource
    private ClassOrderInfoMapper classOrderInfoMapper;

    public int createOrder(ClassOrderInfo orderInfo) {
        return classOrderInfoMapper.add(orderInfo);
    }

    public int updateStatus(Integer orderId, String status) {
        ClassOrderInfo orderInfo = new ClassOrderInfo();
        orderInfo.setId(orderId);
        orderInfo.setStatus(status);
        return classOrderInfoMapper.updateIgnoreNull(orderInfo);
    }

    public int deleteById(Integer orderId) {
        return classOrderInfoMapper.delete(orderId);
    }

    public List<ClassOrderInfo> query(ClassOrderInfo orderInfo) {
        return classOrderInfoMapper.select(orderInfo);
    }
}
