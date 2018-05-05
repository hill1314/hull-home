package com.hull;

import com.hull.annotations.LogAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 日志切面
 *
 * @author
 * @create 2018-05-01 上午10:03
 **/

@Aspect
@Component
public class LogAspect {


    @Pointcut("@annotation(com.hull.annotations.LogAnnotation)")
    public void aspect() {

    }

    @Around("aspect()&&@annotation(logPoint)")
    public Object around(ProceedingJoinPoint joinPoint, LogAnnotation logPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println(logPoint.type());
        System.out.println(logPoint.info());

        return null;
    }
}
