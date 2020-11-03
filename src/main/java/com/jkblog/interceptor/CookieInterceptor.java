package com.jkblog.interceptor;

import com.jkblog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class CookieInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Integer userId = (Integer) request.getSession().getAttribute("userId");

        /*当session中没有用户时，查看当前cookie是否有登录信息*/
        if (userId == null || userId.equals("")) {
            Cookie[] cookies = request.getCookies();
            if(cookies!=null) {
                for (Cookie cookie : cookies) {
                    if ("userId".equals(cookie.getName())) {
                        //stem.out.println(cookie.getPath());
                        String value = cookie.getValue();
                        Integer userIdCookie = Integer.parseInt(value);
                        if (userIdCookie == null || userIdCookie.equals("")) {
                            /*把无用的cookie删了*/
                            deleteCookie(request, response);
                        } else {
                            String userNameByUserId = userService.getUserNameByUserId(userIdCookie);
                            if (userNameByUserId == null || userNameByUserId.equals("")) {
                                /*把无用的cookie删了*/
                                deleteCookie(request, response);
                            } else {
                                request.getSession().setAttribute("userId", userIdCookie);
                                request.getSession().setAttribute("userName", userNameByUserId);
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

    /*删除无用的cookie*/
    public void deleteCookie(HttpServletRequest request,HttpServletResponse response){
        /*cookie不能直接删除，需要用相同路径的cookie覆盖掉*/
        /*cookie名字一样就行*/
        Cookie cookie = new Cookie("userId","");
        /*路径一定一致*/
        cookie.setPath(request.getContextPath()+"/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
