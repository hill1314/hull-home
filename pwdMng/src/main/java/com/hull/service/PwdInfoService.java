package com.hull.service;

import com.hull.entity.PwdInfo;
import com.hull.entity.UserInfo;
import com.hull.mapper.PwdInfoBaseMapper;
import com.hull.mapper.UserInfoBaseMapper;
import com.hull.util.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
    private static final String DEFAULT_SECRET_KEY = "qwer111111111111";

    @Resource
    private PwdInfoBaseMapper pwdInfoMapper;
    @Resource
    private UserInfoBaseMapper userInfoMapper;

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
        String key = getUserKey(pwdInfo.getUserId());
        key = fixKey(key);
        return pwdInfoMapper.add(encrypt(pwdInfo,key));
    }

    /**
     * 查询用户的校验码
     * @param userId
     * @return
     */
    public String getUserKey(Integer userId) {
        UserInfo userInfo = userInfoMapper.get(userId);
        String key = userInfo.getVerifyCode();
        return key;
    }

    /**
     * 校验key
     * @param key
     * @return
     */
    private String fixKey(String key) {
        if(StringUtils.isEmpty(key)){
            key = DEFAULT_SECRET_KEY;
        }else{
            //不足16位，补够16位
            if(key.length()<16){
                StringBuffer buffer = new StringBuffer();
                buffer.append(key);
                for(int n=0;n<16-key.length();n++){
                    buffer.append("1");
                }
                key = buffer.toString();
            }
        }
        return key;
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
        String key = getUserKey(pwdInfo.getUserId());
        key = fixKey(key);
        return pwdInfoMapper.updateIgnoreNull(encrypt(pwdInfo,key));
    }

    /**
     * 加密
     * @param pwdInfo
     * @return
     */
    public PwdInfo encrypt(PwdInfo pwdInfo,String key){
        String encryptStr = pwdInfo.getLoginPwd();
        try {
            String secretKeyStr = SecurityUtil.AesUtil.generaterKey(key);
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
    public String decrypt(String pwd,String key){
        key = fixKey(key);
        String decryptStr = pwd;
        try {
            String secretKeyStr = SecurityUtil.AesUtil.generaterKey(key);
            decryptStr = SecurityUtil.AesUtil.decrypt(decryptStr, secretKeyStr);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
        return decryptStr;
    }
}
