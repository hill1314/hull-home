package com.hull.service;

import com.hull.entity.PwdInfo;
import com.hull.mapper.PwdInfoBaseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 密码管理
 *
 * @author
 * @create 2018-05-05 下午2:21
 **/
@Service
public class PwdInfoService {

    @Resource
    private PwdInfoBaseMapper pwdInfoMapper;

    /**
     * 查找
     * @param PwdInfo
     * @return
     */
    public List<PwdInfo> find(PwdInfo PwdInfo){
        return pwdInfoMapper.select(PwdInfo);
    }

    /**
     * 增
     * @param pwdInfo
     * @return
     */
    public int add(PwdInfo pwdInfo){
        return pwdInfoMapper.add(pwdInfo);
    }

    /**
     * 删
     * @param id
     * @return
     */
    public int del(Long id){
        return pwdInfoMapper.delete(id);
    }

    /**
     * 改
     * @param pwdInfo
     * @return
     */
    public int update(PwdInfo pwdInfo){
        return pwdInfoMapper.updateIgnoreNull(pwdInfo);
    }
}
