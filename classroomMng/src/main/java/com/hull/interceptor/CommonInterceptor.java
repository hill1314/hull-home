package com.hull.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Map;

/**
 * 通用拦截器（打印请求url及请求参数、请求时长）
 *
 * @author
 * @create 2018-03-09 下午10:45
 **/

public class CommonInterceptor extends HandlerInterceptorAdapter {
    Logger logger = LoggerFactory.getLogger(getClass());

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try{
            String parameterStr = getParamStr(request.getParameterMap());
            logger.info("request URL={} begin,parameterMap={{}}",request.getRequestURI(),parameterStr);
            request.setAttribute("beginTime",System.currentTimeMillis());
        }catch (Exception e){
            logger.error("CommonInterceptor preHandle execute error,e={}",e);
        }
        return true;
    }

    /**
     * 解析入参
     * @param parameterMap
     * @return
     */
    private String getParamStr(Map<String, String[]> parameterMap) {
        StringBuffer paramStr = new StringBuffer();
        String parameterStr = "";
        if(!parameterMap.isEmpty()){
            Iterator it = parameterMap.entrySet().iterator();
            while (it.hasNext()){
                Map.Entry entry = (Map.Entry) it.next();
                paramStr.append("\""+entry.getKey() + "\":\"" + parameterMap.get(entry.getKey())[0]+"\",");
            }
            parameterStr = paramStr.toString();
            if(parameterStr.length()>0){
                parameterStr.substring(0,parameterStr.length()-1);
            }
        }
        return parameterStr;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        try {
            Long beginTime = (Long) request.getAttribute("beginTime");
            Long executeTime = System.currentTimeMillis() - beginTime;
            logger.info("request URL={} end, response status={},executeTime={}s",
                    request.getRequestURI(),response.getStatus(),executeTime/1000);
        }catch (Exception e){
            logger.error("CommonInterceptor postHandle execute error,e={}",e);
        }
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {

    }

}
