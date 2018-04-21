package com.hull.service;

import com.alibaba.druid.util.StringUtils;
import com.hull.dto.OrderInfoDto;
import com.hull.entity.OrderInfo;
import com.hull.entity.OrderItem;
import com.hull.mapper.OrderInfoBaseMapper;
import com.hull.mapper.OrderItemBaseMapper;
import com.hull.mapper.SendInfoBaseMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单服务
 *
 * @author
 * @create 2018-04-21 上午8:49
 **/

@Service
public class OrderInfoService {
    @Resource
    private OrderInfoBaseMapper orderInfoBaseMapper;
    @Resource
    private OrderItemBaseMapper orderItemBaseMapper;
    @Resource
    private SendInfoBaseMapper sendInfoBaseMapper;

    /**
     * 添加订单
     * @param orderInfoDto
     * @return
     */
    public OrderInfoDto addOrder(OrderInfoDto orderInfoDto){
        //订单明细
        List<OrderItem> orderItemList = orderInfoDto.getOrderItems();
        if(CollectionUtils.isEmpty(orderItemList)){
            return orderInfoDto;
        }

        //TODO 复制订单属性
        OrderInfo orderInfo = getOrderInfo(orderInfoDto);
        orderInfoBaseMapper.add(orderInfo);

        //保存明细
        for (OrderItem orderItem:orderItemList){
            orderItemBaseMapper.add(orderItem);
        }

        //配送信息
        if(StringUtils.equals(orderInfoDto.getSendType(),"1")
                && orderInfoDto.getSendInfo()!=null){
            sendInfoBaseMapper.add(orderInfoDto.getSendInfo());
        }

        return orderInfoDto;
    }


    private OrderInfo getOrderInfo(OrderInfoDto orderInfoDto) {
        //TODO
        return null;
    }

    /**
     * 支付订单
     * @param orderId
     * @return
     */
    public int payOrder(Long orderId){
        return 0;
    }

    /**
     * 取消订单
     * @param orderId
     * @return
     */
    public int cancelOrder(Long orderId){
        return 0;
    }

}
