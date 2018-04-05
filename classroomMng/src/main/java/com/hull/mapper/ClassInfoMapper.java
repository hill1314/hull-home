package com.hull.mapper;

import com.hull.common.BaseMapper;
import com.hull.entity.ClassInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassInfoMapper extends BaseMapper<Integer,ClassInfo> {

    List<ClassInfo> select(ClassInfo classInfo);
}