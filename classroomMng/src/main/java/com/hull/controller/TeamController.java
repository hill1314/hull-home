package com.hull.controller;

import com.hull.dto.RespDto;
import com.hull.entity.TeamInfo;
import com.hull.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 组
 *
 * @author
 * @create 2018-04-05 上午5:42
 **/
@RestController("/team")
public class TeamController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private TeamService teamService;

    @RequestMapping("add")
    public RespDto<TeamInfo> add(@RequestBody TeamInfo teamInfo){
        int n = teamService.add(teamInfo);
        if(n==0){
            return RespDto.error("保存失败");
        }
        return RespDto.success(teamInfo);
    }

    @RequestMapping("/delete/{teamId}")
    public RespDto<Map<String,String>> delete(@PathVariable Integer teamId){
        int n = teamService.deleteById(teamId);
        if(n==0){
            return RespDto.error("删除失败");
        }
        return RespDto.success();
    }

    @RequestMapping("update")
    public RespDto<TeamInfo> update(@RequestBody TeamInfo teamInfo){
        if(teamInfo==null || teamInfo.getId()==null){
            return RespDto.error("主键为空");
        }
        int n = teamService.update(teamInfo);
        if(n==0){
            return RespDto.error("更新失败");
        }
        return RespDto.success(teamInfo);
    }

    @RequestMapping("query")
    public RespDto<List<TeamInfo>> query(@RequestBody TeamInfo teamInfo){
        List<TeamInfo> list = teamService.query(teamInfo);
        return RespDto.success(list);
    }
}
