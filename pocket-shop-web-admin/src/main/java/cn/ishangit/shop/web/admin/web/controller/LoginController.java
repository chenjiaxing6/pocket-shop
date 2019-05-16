package cn.ishangit.shop.web.admin.web.controller;

import cn.ishangit.shop.commons.constant.ConstantUtils;
import cn.ishangit.shop.commons.constant.CookieUtils;
import cn.ishangit.shop.domain.TbUser;
import cn.ishangit.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private TbUserService tbUserService;

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
   public String login(@RequestParam(required = true) String email, @RequestParam(required = true)String password,String isRemember,
                       HttpServletRequest request, HttpServletResponse response, Model model){

        TbUser tbUser = tbUserService.login(email, password);
        //登陆失败
        if (tbUser == null){
            model.addAttribute("message","用户名或密码错误，请重新输入！");
            return login(request);
        }
        //登陆成功
        else {
            request.getSession().setAttribute(ConstantUtils.SESSION_USER,tbUser);
            if (isRemember!= null) {
                //如果勾选了记住我   就把用户名密码放入session
                CookieUtils.setCookie(request, response, "userInfo", String.format("%s:%s", email, password), 7 * 24 * 60 * 60);
            }else {
                //如果没有勾选，判断cookie中有没有用户名密码信息，有就删除
                if (!StringUtils.isBlank(CookieUtils.getCookieValue(request,"userInfo"))) {
                    CookieUtils.deleteCookie(request, response, "userInfo");
                }
            }
            return "redirect:/main";
        }
   }

    /**
     * 注销
     * @return
     */
   @RequestMapping(value = "logout",method = RequestMethod.GET)
   public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:login";
   }
}
