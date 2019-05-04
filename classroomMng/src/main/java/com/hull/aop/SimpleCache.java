package com.hull.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 缓存注解
 *
 * @author
 * @create 2019-05-04 21:43
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface SimpleCache {

    /**
     * 缓存key
     * @return
     */
    String[] key() default {""};

    /**
     * 缓存的有效时长 秒
     * @return
     */
    int expireTime() default -1;

}
