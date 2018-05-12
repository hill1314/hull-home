package com.hull.common;

/**
 * 数据库实体类公共继承类（带ID）
 *
 * @author
 * @create 2018-04-05 上午5:58
 **/

public class IdEntity extends BaseEntity{
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
