package cn.ishangit.shop.web.ui.controller;

import cn.ishangit.shop.commons.constant.SendEmailUtils;
import cn.ishangit.shop.commons.dto.BaseResult;
import cn.ishangit.shop.web.ui.api.UserApi;
import cn.ishangit.shop.web.ui.constant.SystemConstant;
import cn.ishangit.shop.web.ui.dto.User;
import cn.ishangit.shop.web.ui.dto.UserDto;
import com.google.code.kaptcha.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author: Chen
 * @create: 2019-05-31 22:33
 **/
@Controller
public class UserController {
    @Autowired
    private SendEmailUtils sendEmailUtils;
    /**
     * 登录页面
     */
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    /**
     * 用户登录逻辑
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(User user, Model model, HttpServletRequest request) throws Exception {
        //检查验证码
        if (!checkVerification(user,request)){
            model.addAttribute("BaseResult",BaseResult.fail("验证码输入错误"));
            return login();
        }
        UserDto userDto = UserApi.login(user);
        BaseResult baseResult = null;
        if (userDto == null){
            baseResult = new BaseResult();
            baseResult = baseResult.fail("用户名或密码错误！");
            model.addAttribute("BaseResult",baseResult);
            return login();
        }
        else {
            baseResult = baseResult.success("登录成功！",userDto);
            //发送邮件
            sendEmailUtils.sendEmail("提示",String.format("用户 %s 登陆口袋商城！",userDto.getUsername()),"15754222043@163.com");
            request.getSession().setAttribute(SystemConstant.SESSION_USER,userDto);
            model.addAttribute("BaseResult",baseResult);
        }
        return "redirect:/index";
    }
    /**
     * 判断验证码
     */
    public boolean checkVerification(User user , HttpServletRequest request){
        String verification = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (StringUtils.equals(user.getVerification(),verification)) {
            return true;
        }
        return false;
    }

    /**
     * 注销
     */
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:index";
    }
}
