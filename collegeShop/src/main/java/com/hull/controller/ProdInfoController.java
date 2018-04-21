package com.hull.controller;

import com.hull.dto.RespDto;
import com.hull.entity.ProdInfo;
import com.hull.service.ProdInfoService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 商品管理
 *
 * @auth
 * @create 2018-04-21 上午9:45
 **/
@RestController
@RequestMapping("prod")
public class ProdInfoController {

    @Resource
    private ProdInfoService prodInfoService;

    public RespDto<ProdInfo> addProd(@RequestBody ProdInfo prodInfo){
        int n = prodInfoService.addProd(prodInfo);
        if(n==0){
            return RespDto.error("添加失败");
        }
        return RespDto.success(prodInfo);
    }
}
