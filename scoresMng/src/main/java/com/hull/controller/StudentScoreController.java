package com.hull.controller;

import com.hull.common.RespDto;
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
    public RespDto<List<StudentScore>> select(@RequestBody StudentScore studentScore){
        List<StudentScore> list = studentScoreService.select(studentScore);
        return RespDto.success(list);
    }

}
