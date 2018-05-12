package com.hull.mapper;

import com.hull.entity.StudentScore;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentScoreMapper {


    List<StudentScore> select(StudentScore studentScore);

}