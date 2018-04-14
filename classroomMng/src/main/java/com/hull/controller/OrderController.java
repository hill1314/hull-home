package com.hull.controller;

import com.hull.dto.RespDto;
import com.hull.entity.ClassOrderInfo;
import com.hull.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 预约单
 *
 * @author
 * @create 2018-04-05 上午5:41
 **/

@RestController
@RequestMapping("order")
public class OrderController {
    @Resource
    private OrderService orderService;

    /**
     * 创建预约
     * @param orderInfo
     * @return
     */
    @RequestMapping("createOrder")
    public RespDto<ClassOrderInfo> create(@RequestBody ClassOrderInfo orderInfo){
        int n = orderService.createOrder(orderInfo);
        if(n==0){
            return RespDto.error("创建预约失败");
        }
        return RespDto.success(orderInfo);
    }

    /**
     * 审批预约
     * @param orderId
     * @param status
     * @return
     */
    @RequestMapping("/approveOrder/{orderId}/{status}")
    public RespDto<Map<String,Object>> approve(@PathVariable Integer orderId,
                                               @PathVariable String status,
                                               @RequestParam(value = "reason",required = false) String reason
    ){
        if(orderId==null || status==null){
            return RespDto.error("参数错误");
        }
        int n = orderService.updateStatus(orderId,status,reason);
        if(n==0){
            return RespDto.error("审批失败");
        }
        return RespDto.success();
    }

    /**
     * 删除预约
     * @param orderId
     * @return
     */
    @RequestMapping("/deleteOrder/{orderId}")
    public RespDto<Map<String,String>> delete(@PathVariable Integer orderId){
        if(orderId==null){
            return RespDto.error("参数为空");
        }
        int n = orderService.deleteById(orderId);
        if(n==0){
            return RespDto.error("删除失败");
        }
        return RespDto.success();
    }

    /**
     * 查询历史预约信息
     * @param orderInfo
     * @return
     */
    @RequestMapping("queryOrder")
    public RespDto<List<ClassOrderInfo>> query(@RequestBody ClassOrderInfo orderInfo){
        List<ClassOrderInfo> list = orderService.query(orderInfo);
        return RespDto.success(list);
    }


}
