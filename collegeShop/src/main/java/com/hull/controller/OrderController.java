package com.hull.controller;


import com.hull.dto.RespDto;
import com.hull.entity.OrderInfo;
import com.hull.service.OrderInfoService;
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
    private OrderInfoService orderInfoService;



}
