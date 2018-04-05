package com.hull.mapper;

import com.hull.common.BaseMapper;
import com.hull.entity.StaffInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffInfoMapper extends BaseMapper<Integer,StaffInfo> {


    List<StaffInfo> select(StaffInfo staffInfo);
}