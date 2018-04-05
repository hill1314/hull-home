package com.hull.controller;

import com.hull.dto.RespDto;
import com.hull.entity.ClassInfo;
import com.hull.service.ClassService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 会议室(教室) 控制层
 *
 * @author
 * @create 2018-04-05 上午5:41
 **/
@RestController
@RequestMapping("class")
public class ClassController {
    @Resource
    private ClassService classService;

    /**
     * 添加会议室
     * @param classInfo
     * @return
     */
    @RequestMapping("add")
    public RespDto<ClassInfo> add(@RequestBody ClassInfo classInfo){
        int n = classService.add(classInfo);
        if(n==0){
            return RespDto.error("保存失败");
        }
        return RespDto.success(classInfo);
    }

    /**
     * 删除会议室
     * @param classId
     * @return
     */
    @RequestMapping("/delete/{classId}")
    public RespDto<Map<String,String>> delete(@PathVariable Integer classId){
        int n = classService.deleteById(classId);
        if(n==0){
            return RespDto.error("删除失败");
        }
        return RespDto.success();
    }

    /**
     * 更新会议室
     * @param classInfo
     * @return
     */
    @RequestMapping("update")
    public RespDto<ClassInfo> update(@RequestBody ClassInfo classInfo){
        if(classInfo==null || classInfo.getId()==null){
            return RespDto.error("主键为空");
        }
        int n = classService.update(classInfo);
        if(n==0){
            return RespDto.error("更新失败");
        }
        return RespDto.success(classInfo);
    }

    /**
     * 查询会议室
     * @param classInfo
     * @return
     */
    @RequestMapping("query")
    public RespDto<List<ClassInfo>> query(@RequestBody ClassInfo classInfo){
        List<ClassInfo> list = classService.query(classInfo);
        return RespDto.success(list);
    }
}
