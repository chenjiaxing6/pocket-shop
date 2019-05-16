package cn.ishangit.shop.web.admin.web.controller;

import cn.ishangit.shop.domain.TbUser;
import cn.ishangit.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Chen
 * @create 2019-05-16 19:55
 * 用户管理
 */
@RequestMapping(value = "user")
@Controller
public class TbUserController {

    @Autowired
    private TbUserService userService;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(Model model){
        List<TbUser> tbUsers = userService.selectAll();
        model.addAttribute("tbUsers",tbUsers);
        return "user_list";
    }
}
