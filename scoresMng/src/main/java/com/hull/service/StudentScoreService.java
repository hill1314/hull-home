package com.hull.service;

import com.hull.entity.StudentScore;
import com.hull.mapper.StudentScoreMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 *
 * @author
 * @create 2018-05-12 下午1:45
 **/
@Service
public class StudentScoreService {

    @Resource
    private StudentScoreMapper studentScoreMapper;

    public List<StudentScore> select(StudentScore studentScore){
        return studentScoreMapper.select(studentScore);
    }
}
