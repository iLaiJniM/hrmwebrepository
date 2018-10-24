package com.lijiamin.interceptor;

import com.lijiamin.model.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 31543 on 2018/10/19.
 */
public class UserLoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        if(request.getRequestURI().equals("/toJspInterceptor")||request.getRequestURI().equals("/toResumeCenterJspInterceptor")) {
            User loginUser = (User) request.getSession().getAttribute("loginUser");
            if(null==loginUser){
                request.getRequestDispatcher("WEB-INF/pages/userLogin.jsp").forward(request,response);
                return false;
            }
        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {

    }
}
