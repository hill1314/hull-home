package com.hull.entity;

import lombok.Getter;

/**
 * 查询条件
 *
 * @author
 * @create 2018-05-12 下午5:02
 **/
@Getter
public class ScoreQueryDto {
    /**
     学号
     **/
    private String studentId;
    /**
     姓名
     **/
    private String studentName;
    /**
     总分
     **/
    private Integer totalScoreLess;
    private Integer totalScoreMore;
    /**
     门数
     **/
    private Integer lessonNum;
    /**
     性别
     **/
    private String sex;
    /**
     总学分
     **/
    private Integer totalCreditLess;
    private Integer totalCreditMore;
    /**
     学分加权平均分
     **/
    private Integer averageCreditLess;
    private Integer averageCreditMore;
    /**
     班级排名
     **/
    private Integer ranking;

    /**
     * 排序字段
     */
    private String orderBy;
}
