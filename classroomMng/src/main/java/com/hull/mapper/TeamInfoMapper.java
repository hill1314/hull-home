package com.hull.mapper;

import com.hull.common.BaseMapper;
import com.hull.entity.TeamInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamInfoMapper extends BaseMapper<Integer,TeamInfo> {

    List<TeamInfo> select(TeamInfo teamInfo);
}