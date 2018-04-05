package com.hull.service;

import com.hull.entity.ClassInfo;
import com.hull.mapper.ClassInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 会议室(教室) 相关服务
 *
 * @author
 * @create 2018-04-05 上午6:26
 **/

@Service
public class ClassService {
    @Resource
    private ClassInfoMapper classInfoMapper;

    public int add(ClassInfo classInfo) {
        return classInfoMapper.add(classInfo);
    }

    public int deleteById(Integer classId) {
        return classInfoMapper.delete(classId);
    }

    public int update(ClassInfo classInfo) {
        return classInfoMapper.updateIgnoreNull(classInfo);
    }

    public List<ClassInfo> query(ClassInfo classInfo) {
        return classInfoMapper.select(classInfo);
    }
}
