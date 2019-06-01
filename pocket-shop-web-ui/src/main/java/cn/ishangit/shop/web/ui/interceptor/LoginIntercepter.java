package cn.ishangit.shop.web.ui.interceptor;

import cn.ishangit.shop.web.ui.constant.SystemConstant;
import cn.ishangit.shop.web.ui.dto.UserDto;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:登录拦截器
 * @author: Chen
 * @create: 2019-06-01 12:21
 **/
public class LoginIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        UserDto user = (UserDto) request.getSession().getAttribute(SystemConstant.SESSION_USER);
        //登录
        if (user == null){
            return true;
        }
        //已经登录
        else {
            response.sendRedirect("/index");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
