package com.hull.mapper;

import com.hull.common.BaseMapper;
import com.hull.entity.ClassOrderInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassOrderInfoMapper extends BaseMapper<Integer,ClassOrderInfo> {

    List<ClassOrderInfo> select(ClassOrderInfo orderInfo);
}