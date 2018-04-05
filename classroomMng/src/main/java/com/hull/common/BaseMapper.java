package com.hull.common;

/**
 * mapper 公共继承类
 *
 * @author
 * @create 2018-04-05 上午6:18
 **/

public interface BaseMapper<PK, T> {
    int add(T var1);

    int delete(PK var1);

    int updateIgnoreNull(T var1);

    int update(T var1);

    T get(PK var1);
}
