package com.hull.aop;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BasicAop {

    public static final Map<String, Field> FIELD_MAP = new ConcurrentHashMap();


    public BasicAop() {
    }


    protected Field getField(Class<?> aClass, String fieldName) throws NoSuchFieldException {
        String fieldKey = aClass.toString() + fieldName;
        Field field = (Field)FIELD_MAP.get(fieldKey);
        if (field != null) {
            return field;
        } else {
            field = aClass.getField(fieldName);
            if (field == null) {
                return null;
            } else {
                field.setAccessible(true);
                FIELD_MAP.put(fieldKey, field);
                return field;
            }
        }
    }

    /**
     * 方法参数键值对
     * @param pjp
     * @return
     */
    protected Map<String, Object> getArgName2Value(JoinPoint pjp) {
        //方法参数名
        String[] argNames = this.getArgNames(pjp);
        //参数值
        Object[] argValues = pjp.getArgs();
        Map<String, Object> argName2Value = new HashMap(argNames.length);
        //方法参数键值对
        for(int i = 0; i < argNames.length; ++i) {
            argName2Value.put(argNames[i], argValues[i]);
        }

        return argName2Value;
    }

    /**
     * 获取方法参数
     * @param pjp
     * @return
     */
    protected String[] getArgNames(JoinPoint pjp) {
        MethodSignature methodSignature = (MethodSignature)pjp.getSignature();
        return methodSignature.getParameterNames();
    }

    /**
     * 获取注解所在的方法名
     * @param pjp
     * @return
     */
    protected String getMethodName(JoinPoint pjp) {
        Method method = this.getMethod(pjp);
        return null == method ? "" : method.getName();
    }

    /**
     * 获取注解所在的方法
     * @param pjp
     * @return
     */
    protected Method getMethod(JoinPoint pjp) {
        MethodSignature signature = (MethodSignature)pjp.getSignature();
        return signature.getMethod();
    }

    /**
     * 获取方法的返回类型
     * @param pjp
     * @return
     */
    protected Type getReturnType(ProceedingJoinPoint pjp) {
        Method method = this.getMethod(pjp);
        return method.getGenericReturnType();
    }

    /**
     * 获取完整类名
     * @param pjp
     * @return
     */
    protected String getTargetClassFullName(JoinPoint pjp) {
        return pjp.getTarget().getClass().getName();
    }

    /**
     * 获取类名
     * @param pjp
     * @return
     */
    protected String getTargetClassName(JoinPoint pjp) {
        String targetClassFullName = this.getTargetClassFullName(pjp);
        if (StringUtils.isNotEmpty(targetClassFullName)) {
            int lastIndexOf = targetClassFullName.lastIndexOf(".");
            return lastIndexOf < 0 ? targetClassFullName : targetClassFullName.substring(lastIndexOf + 1);
        } else {
            return "";
        }
    }
}