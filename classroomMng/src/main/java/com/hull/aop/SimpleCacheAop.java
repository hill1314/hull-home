package com.hull.aop;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Splitter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 缓存注解aop
 *
 * @author
 * @create 2019-05-04 21:50
 **/

@Slf4j
@Aspect
@Component
public class SimpleCacheAop extends BasicAop{

    private static Splitter splitter = Splitter.on('.');
    public static final String EMPTY_CACHE_VALUE_FLAG = "###+--**-+###";
    private static volatile ConcurrentHashMap<String,String> cacheMap = new ConcurrentHashMap<>();

    @Around("@annotation(com.hull.aop.SimpleCache) && @annotation(cache)")
//    @Around("execution(* *(..)) && @annotation(cache)")
    public Object simpleRedisCache(ProceedingJoinPoint joinPoint, SimpleCache cache) throws Throwable {

        String className = getTargetClassName(joinPoint);
        String methodName = getMethodName(joinPoint);
        Map<String, Object> params = getArgName2Value(joinPoint);

        //生成缓存的key
        String cacheKey = justJoinToGetCacheKey(className,methodName,params,cache.key());

        //缓存的key，如果key长度超过50.进行压缩
        if(cacheKey.length() > 50){
            cacheKey = md5str(cacheKey);
        }
        log.info("simpleRedisCache method：{},calKey:{},key:{}", methodName,cacheKey, cacheKey);


        //获取缓存的值
        if(containKey(cacheKey)){
            String cacheVal = getCacheValue(cacheKey);
            Type returnType = this.getReturnType(joinPoint);
            log.info("缓存method：{},key:{},命中缓存,val:{}", methodName, cacheKey,cacheVal);
            return JSON.parseObject(cacheVal,returnType);
        }

        log.info("缓存method：{},key:{},未命中缓存.", methodName, cacheKey);
        //交还给原方法处理
        Object res = joinPoint.proceed();
        //如果方法返回结果不为空，缓存结果（分为字符串和其他两种方式存）
        if (null != res) {
            if (res instanceof Character) {
                if (cache.expireTime() > 0) {
//                    stringRedisTemplate.opsForValue().set(cacheKey, res.toString(), (long)cache.expireTime(), TimeUnit.SECONDS);
                    log.info("缓存method：{},key:{},val:{},有效期:{}", methodName, cacheKey,res.toString(),cache.expireTime());
                    cacheMap.put(cacheKey,res.toString());
                } else {
                    log.info("永久 缓存method：{},key:{},val:{}", methodName, cacheKey,res.toString());
                    cacheMap.put(cacheKey,res.toString());
                }
            } else {
                String jsonVal = JSON.toJSONString(res);
                if (StringUtils.isNotEmpty(jsonVal)) {
                    if (cache.expireTime() > 0) {
                        log.info("缓存method：{},key:{},val:{},有效期:{}", methodName, cacheKey,jsonVal,cache.expireTime());
//                        stringRedisTemplate.opsForValue().set(cacheKey, jsonVal, (long)cache.expireTime(), TimeUnit.SECONDS);
                        cacheMap.put(cacheKey,jsonVal);
                    } else {
                        log.info("永久 缓存method：{},key:{},val:{}", methodName, cacheKey,jsonVal);
//                        stringRedisTemplate.opsForValue().set(cacheKey, jsonVal);
                        cacheMap.put(cacheKey,jsonVal);
                    }
                } else {
                    log.info("缓存method:{},key：{}，失败，方法返回值序列化为json为空", methodName, cacheKey);
                }
            }
        }else {
            log.warn("针对返回null 的也缓存一会");
        }

        return res;
    }

    /**
     * 从缓存中获取 cache值
     * @param cacheKey
     * @return
     */
    private String getCacheValue(String cacheKey) {
        return cacheMap.get(cacheKey);
    }

    /**
     * 判断缓存中是否有 cacheKey
     * @param cacheKey
     * @return
     */
    private boolean containKey(String cacheKey) {
        return cacheMap.containsKey(cacheKey);
    }



    /**
     * 生成缓存的key
     * @param className
     * @param methodName
     * @param argName2Value
     * @param specificKeys
     * @return
     */
    protected String justJoinToGetCacheKey(String className, String methodName, Map<String, Object> argName2Value, String... specificKeys) {
        try {
            String cacheKey = StringUtils.isEmpty(className) ? "method-cache-" : className + "-" + methodName + "-";
            List<String> results = new ArrayList(specificKeys.length);

            String[] keyNames = specificKeys;
            for(int i = 0; i < specificKeys.length; ++i) {
                Object realValue = getRealValueByMethodArgs(argName2Value, keyNames[i]);
                if (realValue == null) {
                    results.add("");
                } else {
                    results.add(realValue.toString());
                }
            }

            cacheKey = cacheKey + StringUtils.join(results, "");
            return cacheKey;
        } catch (Exception var11) {
            throw new RuntimeException(var11);
        }
    }

    /**
     * 获取指定参数的值
     * @param argName2Value
     * @param specificKey
     * @return
     */
    protected Object getRealValueByMethodArgs(Map<String, Object> argName2Value, String specificKey) {
        try {
            if (specificKey.startsWith("{") && specificKey.endsWith("}")) {
                specificKey = specificKey.substring(1, specificKey.length() - 1);
                List<String> fields = splitter.splitToList(specificKey);
                if (!argName2Value.containsKey(fields.get(0))) {
                    return null;
                } else {
                    Object argObject = argName2Value.get(fields.get(0));
                    Iterator<String> iterator = fields.iterator();
                    iterator.next();

                    while(iterator.hasNext() && argObject != null) {
                        String fieldName = iterator.next();
                        Field field = this.getField(argObject.getClass(), fieldName);
                        argObject = field.get(argObject);
                    }

                    return argObject;
                }
            } else {
                return specificKey;
            }
        } catch (Exception var8) {
            throw new RuntimeException(var8);
        }
    }


    /**
     * 将内容通过md5压缩
     * @param plainText
     * @return
     */
    private static String md5str(String plainText) {
        String re_md5;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }

            re_md5 = buf.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return plainText;
        }
        return re_md5;
    }
}
