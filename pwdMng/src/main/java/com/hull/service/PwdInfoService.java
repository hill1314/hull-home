package com.hull.service;

import com.hull.entity.PwdInfo;
import com.hull.mapper.PwdInfoBaseMapper;
import com.hull.util.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 密码管理
 *
 * @author
 * @create 2018-05-05 下午2:21
 **/
@Slf4j
@Service
public class PwdInfoService {
    private static final String DEFAULT_SECRET_KEY = "0123456789ABCDEF";

    @Resource
    private PwdInfoBaseMapper pwdInfoMapper;

    /**
     * 列表
     * @param pwdInfo
     * @return
     */
    public List<PwdInfo> find(PwdInfo pwdInfo){
        return pwdInfoMapper.select(pwdInfo);
    }


    /**
     * 增
     * @param pwdInfo
     * @return
     */
    public int add(PwdInfo pwdInfo){
        return pwdInfoMapper.add(encrypt(pwdInfo));
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
        return pwdInfoMapper.updateIgnoreNull(encrypt(pwdInfo));
    }

    /**
     * 加密
     * @param pwdInfo
     * @return
     */
    public PwdInfo encrypt(PwdInfo pwdInfo){
        String encryptStr = pwdInfo.getLoginPwd();
        try {
            String secretKeyStr = SecurityUtil.AesUtil.generaterKey(DEFAULT_SECRET_KEY);
            encryptStr = SecurityUtil.AesUtil.encrypt(encryptStr, secretKeyStr);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        pwdInfo.setLoginPwd(encryptStr);
        return pwdInfo;
    }

    /**
     * 解密
     * @param pwd
     * @return
     */
    public String decrypt(String pwd){
        String decryptStr = pwd;
        try {
            String secretKeyStr = SecurityUtil.AesUtil.generaterKey(DEFAULT_SECRET_KEY);
            decryptStr = SecurityUtil.AesUtil.decrypt(decryptStr, secretKeyStr);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return decryptStr;
    }
}
