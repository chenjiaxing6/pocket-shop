package cn.ishangit.shop.web.admin.web.controller;

import cn.ishangit.shop.commons.constant.ConstantUtils;
import cn.ishangit.shop.commons.constant.CookieUtils;
import cn.ishangit.shop.domain.User;
import cn.ishangit.shop.web.admin.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author Chen
 * @create 2019-05-15 16:29
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 跳转到登录页面
     */
    @RequestMapping(value = {"","login"},method = RequestMethod.GET)
    public String login(HttpServletRequest request){
        String userInfo = CookieUtils.getCookieValue(request,"userInfo");
    if (!StringUtils.isBlank(userInfo)){
        String[] userInfoArr = userInfo.split(":");
        request.setAttribute("email",userInfoArr[0]);
        request.setAttribute("password",userInfoArr[1]);
        request.setAttribute("isRemember","true");
    }
        return "login";
    }

    /**
     * 登录逻辑
     * @param email
     * @param password
     * @param request
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
   public String login(@RequestParam(required = true) String email, @RequestParam(required = true)String password,
                       HttpServletRequest request, HttpServletResponse response){
        User user = userService.login(email,password);

        if (user == null){
            return "/login";
        }else {
            request.getSession().setAttribute(ConstantUtils.SESSION_USER,user);
            CookieUtils.setCookie(request,response,"userInfo",String.format("%s:%s",email,password),7*24*60*60);
        }
        return "redirect:/main";
   }

    /**
     * 注销
     * @return
     */
   @RequestMapping(value = "logout",method = RequestMethod.GET)
   public String logout(HttpServletRequest request){
        request.getSession().invalidate();;
        return "/login";
   }
}
