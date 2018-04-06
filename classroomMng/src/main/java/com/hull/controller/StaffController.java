package com.hull.controller;

import com.hull.dto.RespDto;
import com.hull.entity.StaffInfo;
import com.hull.service.StaffService;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 员工操作
 *
 * @author
 * @create 2018-04-05 上午5:41
 **/
@RestController
@RequestMapping("staff")
public class StaffController {

    @Resource
    private StaffService staffService;

    /**
     * 添加员工(用户)
     * @param staffInfo
     * @return
     */
    @RequestMapping("/addStaff")
    public RespDto<StaffInfo> add(@RequestBody StaffInfo staffInfo){
        int n = staffService.add(staffInfo);
        if(n==0){
            return RespDto.error("添加失败");
        }
        return RespDto.success(staffInfo);
    }

    /**
     * 删除员工
     * @param staffId
     * @return
     */
    @RequestMapping("/deleteStaff/{staffId}")
    public RespDto<Map<String,String>> delete(@PathVariable Integer staffId){
        int n = staffService.deleteById(staffId);
        if(n==0){
            return RespDto.error("删除失败");
        }
        return RespDto.success();
    }

    /**
     * 更新员工信息
     * @param staffInfo
     * @return
     */
    @RequestMapping("/updateStaff")
    public RespDto<StaffInfo> update(@RequestBody StaffInfo staffInfo){
        if(staffInfo==null || staffInfo.getId()==null){
            return RespDto.error("主键为空");
        }
        StaffInfo staff = new StaffInfo();
        staff.setId(staffInfo.getId());
        List<StaffInfo> staffs = staffService.get(staff);
        if(CollectionUtils.isEmpty(staffs)){
            return RespDto.error("找不到对应的用户，员工ID错误");
        }

        int n = staffService.update(staffInfo);
        if(n==0){
            return RespDto.error("更新失败");
        }
        return RespDto.success();
    }

    /**
     * 查询员工列表
     * @param staffInfo
     * @return
     */
    @RequestMapping("/queryStaff")
    public RespDto<List<StaffInfo>> query(@RequestBody StaffInfo staffInfo){
        List<StaffInfo> list = staffService.get(staffInfo);
        return RespDto.success(list);
    }
}
