package com.hull.service;

import com.hull.entity.TeamInfo;
import com.hull.mapper.TeamInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 组相关服务
 *
 * @author
 * @create 2018-04-05 上午6:26
 **/

@Service
public class TeamService {
    @Resource
    private TeamInfoMapper teamInfoMapper;

    public int add(TeamInfo teamInfo) {
        return teamInfoMapper.add(teamInfo);
    }

    public int deleteById(Integer teamId) {
        return teamInfoMapper.delete(teamId);
    }

    public int update(TeamInfo teamInfo) {
        return teamInfoMapper.updateIgnoreNull(teamInfo);
    }

    public List<TeamInfo> query(TeamInfo teamInfo) {
        return teamInfoMapper.select(teamInfo);
    }
}
