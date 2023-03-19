package com.HrSystem.interceptor;

import com.HrSystem.entity.User;
import com.HrSystem.service.UserService;
import com.HrSystem.utils.CookieUtil;
import com.HrSystem.utils.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author hrq
 * @date 2023/03/17
 */

@Component
public class LoginTicketInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    //注入持有用户信息的工具类
    @Autowired
    private HostHolder hostHolder;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //从request中的cookie中获取凭证
        String ticket = CookieUtil.getValue(request,"ticket");

        if (ticket != null){
            User user = userService.findUserById(Integer.valueOf(ticket));
            //本次请求中持有用户
            hostHolder.setUsers(user);
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            System.out.println("setSession");
        }
        return true;
    }

    //模板使用结束后释放掉hostholder里的用户
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        hostHolder.clear();
    }
}
