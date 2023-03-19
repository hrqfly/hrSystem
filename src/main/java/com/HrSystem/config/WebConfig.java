package com.HrSystem.config;

import com.HrSystem.interceptor.AlphaInterceptor;
import com.HrSystem.interceptor.LoginTicketInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author hrq
 * @date 2023/03/17
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private AlphaInterceptor alphaInterceptor;

    @Autowired
    private LoginTicketInterceptor loginTicketInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(alphaInterceptor)
                //.excludePathPatterns("/login")
                .addPathPatterns("/login");   //配置拦截的路径
        registry.addInterceptor(loginTicketInterceptor)
                .addPathPatterns("/login");   //配置拦截的路径;
    }
}
