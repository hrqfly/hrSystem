package com.HrSystem.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hrq
 * @date 2023/03/17
 */

@Component
public class AlphaInterceptor implements HandlerInterceptor {

    // 在controller之前执行


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("alphaInterceptor");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    // controller之后执行的
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("alphaInterceptor");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    // 在模板之前执行

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("alphaInterceptor");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
