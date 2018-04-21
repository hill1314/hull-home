package com.hull.service;

import com.hull.entity.ProdInfo;
import com.hull.mapper.ProdInfoBaseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/** 商品相关服务
 *
 * @author
 * @create 2018-04-21 上午8:51
 **/
@Service
public class ProdInfoService {
    @Resource
    private ProdInfoBaseMapper prodInfoBaseMapper;

    public int addProd(ProdInfo prodInfo) {
        return prodInfoBaseMapper.add(prodInfo);
    }

    public int deleteById(Long prodId) {
        return prodInfoBaseMapper.delete(prodId);
    }

    public int update(ProdInfo prodInfo){
        return prodInfoBaseMapper.updateIgnoreNull(prodInfo);
    }

    public List<ProdInfo> select(ProdInfo prodInfo) {
        return prodInfoBaseMapper.select(prodInfo);
    }

    public ProdInfo get(Long prodId) {
        return prodInfoBaseMapper.get(prodId);
    }

}
