package com.hull.controller;

import com.hull.common.RespDto;
import com.hull.entity.ScoreQueryDto;
import com.hull.entity.StudentScore;
import com.hull.service.StudentScoreService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 *
 * @author
 * @create 2018-05-12 下午1:46
 **/
@RestController
@RequestMapping("score")
public class StudentScoreController {

    @Resource
    private StudentScoreService studentScoreService;

    @RequestMapping("list")
    public RespDto<List<StudentScore>> select(@RequestBody ScoreQueryDto scoreQueryDto){
        List<StudentScore> list = studentScoreService.select(scoreQueryDto);
        return RespDto.success(list);
    }


    @RequestMapping("add")
    public RespDto<StudentScore> add(@RequestBody StudentScore studentScore){
        int n = studentScoreService.add(studentScore);
        if(n==0){
            RespDto.error("添加失败");
        }
        return RespDto.success(studentScore);
    }
}
