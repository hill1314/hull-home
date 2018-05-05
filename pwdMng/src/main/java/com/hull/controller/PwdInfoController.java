package com.hull.controller;

import com.hull.entity.PwdInfo;
import com.hull.entity.RespDto;
import com.hull.service.PwdInfoService;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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

    @RequestMapping("list")
    public RespDto<List<PwdInfo>> list(@RequestBody PwdInfo pwdInfo){
        List<PwdInfo> pwdInfoList = pwdInfoService.find(pwdInfo);
        return RespDto.success(pwdInfoList);
    }

    @RequestMapping("decrypt")
    public RespDto<String> decrypt(@RequestBody PwdInfo pwdInfo){
        if(StringUtils.isEmpty(pwdInfo.getLoginCode()) || StringUtils.isEmpty(pwdInfo.getUserId())){
            return RespDto.error("登陆名、用户ID 不能为空");
        }
        List<PwdInfo> pwdInfoList = pwdInfoService.find(pwdInfo);
        if(CollectionUtils.isEmpty(pwdInfoList)){
            return RespDto.error("无此信息");
        }
        String pwd = pwdInfoService.decrypt(pwdInfoList.get(0).getLoginPwd());
        return RespDto.success(pwd);
    }

    @RequestMapping("add")
    public RespDto<PwdInfo> add(@RequestBody PwdInfo pwdInfo){
        if(StringUtils.isEmpty(pwdInfo.getLoginCode()) || StringUtils.isEmpty(pwdInfo.getLoginPwd())
                || StringUtils.isEmpty(pwdInfo.getUserId())){
            return RespDto.error("登陆名、密码、用户ID 不能为空");
        }
        int n = pwdInfoService.add(pwdInfo);
        if(n==0){
            return RespDto.error("添加失败");
        }
        return RespDto.success(pwdInfo);
    }
    
    @RequestMapping("modify")
    public RespDto<PwdInfo> modify(@RequestBody PwdInfo pwdInfo){
        if(StringUtils.isEmpty(pwdInfo.getId())){
            return RespDto.error("主键为空");
        }
        int n = pwdInfoService.update(pwdInfo);
        if(n==0){
            return RespDto.error("修改失败");
        }
        return RespDto.success(pwdInfo);
    }

    @RequestMapping("del/{id}")
    public RespDto<PwdInfo> del(@PathVariable Long id){
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
