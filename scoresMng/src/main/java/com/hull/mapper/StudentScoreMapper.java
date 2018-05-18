package com.hull.mapper;

import com.hull.entity.ScoreQueryDto;
import com.hull.entity.StudentScore;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentScoreMapper {


    List<StudentScore> select(ScoreQueryDto scoreQueryDto);

    int add(StudentScore studentScore);

    StudentScore get(String studentId);

    int updateIgnoreNull(StudentScore studentScore);
}