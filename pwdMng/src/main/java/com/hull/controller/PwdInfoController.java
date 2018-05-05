package com.hull.controller;

import com.hull.entity.PwdInfo;
import com.hull.entity.RespDto;
import com.hull.service.PwdInfoService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 密码管理
 *
 * @author
 * @create 2018-05-05 下午2:32
 **/

@RestController
@RequestMapping("pwd")
public class PwdInfoController {
    @Resource
    private PwdInfoService pwdInfoService;

    @RequestMapping("add")
    public RespDto<PwdInfo> add(PwdInfo pwdInfo){
        int n = pwdInfoService.add(pwdInfo);
        if(n==0){
            return RespDto.error("添加失败");
        }
        return RespDto.success(pwdInfo);
    }
    
    @RequestMapping("modify")
    public RespDto<PwdInfo> modify(PwdInfo pwdInfo){
        if(StringUtils.isEmpty(pwdInfo.getId())){
            return RespDto.error("主键为空");
        }
        int n = pwdInfoService.update(pwdInfo);
        if(n==0){
            return RespDto.error("修改失败");
        }
        return RespDto.success(pwdInfo);
    }

    @RequestMapping("del")
    public RespDto<PwdInfo> del(Long id){
        if(StringUtils.isEmpty(id)){
            return RespDto.error("主键为空");
        }
        int n = pwdInfoService.del(id);
        if(n==0){
            return RespDto.error("删除失败");
        }
        return RespDto.success();
    }


}
