package edu.dgut.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //特殊的请求放行
        String requestURI = request.getRequestURI();
        if (requestURI.equalsIgnoreCase("/api/user/login") || requestURI.equalsIgnoreCase("/api/user/register")){
            return true;
        }

        //1.判断用户是不是登录？
        String user = null;
        Cookie[] cookies  = request.getCookies();
        for (Cookie c: cookies) {
            if(c.getName().equals("user")){
                user = c.getValue();
                break;
            }
        }
        if (user!=null){
            //用户已经登录
            return true;
        }else {
            //3、如果没登录
            //request.getRequestDispatcher("/login").forward(request,response);
            return false;
        }

    }
}
