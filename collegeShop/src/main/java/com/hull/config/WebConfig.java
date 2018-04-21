package com.hull.config;

import com.hull.interceptor.CommonInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * web 相关配置
 *
 * @author
 * @create 2018-03-09 下午10:50
 **/

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 添加web拦截器
     * @param registry
     */
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CommonInterceptor()).addPathPatterns("/**");
    }
}
