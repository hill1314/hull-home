package com.hull.annotations;

import java.lang.annotation.*;

/**
 * 日志注解
 *
 * @author
 * @create 2018-05-01 上午8:56
 **/

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@Inherited
@Documented
public @interface LogAnnotation{

    /**
     * 0 - debug
     * 1 - info
     * 2 - warn
     * 3 - error
     * @return
     */
    int type() default 1;
    String info() default "";
}
