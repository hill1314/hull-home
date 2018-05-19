package com.hull.service;

import com.alibaba.fastjson.JSON;
import com.hull.entity.ScoreQueryDto;
import com.hull.entity.StudentScore;
import com.hull.mapper.StudentScoreMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private StudentScoreMapper studentScoreMapper;

    public List<StudentScore> select(ScoreQueryDto studentScore){
        List<StudentScore> list = studentScoreMapper.select(studentScore);
        if(!CollectionUtils.isEmpty(list)){
            logger.info(JSON.toJSONString(list.get(0)));
        }
        return list;
    }

    public int add(StudentScore studentScore){
        StudentScore score = studentScoreMapper.get(studentScore.getStudentId());
        if(score==null){
            return studentScoreMapper.add(studentScore);
        }else {
            return studentScoreMapper.updateIgnoreNull(studentScore);
        }
    }


    public int delete(String studentId) {
        StudentScore score = studentScoreMapper.get(studentId);
        if(score!=null){
            return studentScoreMapper.delete(studentId);
        }
        return 1;
    }

}
