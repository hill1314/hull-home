package com.hull.service;

import com.hull.annotations.LogAnnotation;
import com.hull.dto.RespDto;
import com.hull.entity.StaffInfo;
import com.hull.mapper.StaffInfoMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 员工相关服务
 *
 * @author
 * @create 2018-04-05 上午6:26
 **/

@Service
public class StaffService {
    @Resource
    private StaffInfoMapper staffInfoMapper;

    @LogAnnotation(type = 1,info = "getByNameAndPwd")
    public StaffInfo getByNameAndPwd(String name, String pwd) {
        StaffInfo staffInfo = new StaffInfo();
        staffInfo.setName(name);
        staffInfo.setPassword(pwd);
        List<StaffInfo> staffInfoList = staffInfoMapper.select(staffInfo);
        if(CollectionUtils.isEmpty(staffInfoList)){
            return null;
        }
        return staffInfoList.get(0);
    }

    public int add(StaffInfo staffInfo) {
        return staffInfoMapper.add(staffInfo);
    }

    public int deleteById(Integer staffId) {
        return staffInfoMapper.delete(staffId);
    }

    public int update(StaffInfo staffInfo) {
        return staffInfoMapper.updateIgnoreNull(staffInfo);
    }

    public List<StaffInfo> get(StaffInfo staffInfo) {
        return staffInfoMapper.select(staffInfo);
    }
}
