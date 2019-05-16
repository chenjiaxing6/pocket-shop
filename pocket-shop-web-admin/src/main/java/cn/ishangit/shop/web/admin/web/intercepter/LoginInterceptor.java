package cn.ishangit.shop.web.admin.web.intercepter;

import cn.ishangit.shop.commons.constant.ConstantUtils;
import cn.ishangit.shop.domain.TbUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Chen
 * @create 2019-05-15 17:06
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        TbUser user = (TbUser)httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_USER);

        if (user == null){
            httpServletResponse.sendRedirect("/login");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
