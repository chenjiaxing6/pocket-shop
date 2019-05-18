package cn.ishangit.shop.web.admin.web.controller;

import cn.ishangit.shop.commons.dto.BaseResult;
import cn.ishangit.shop.domain.TbUser;
import cn.ishangit.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @ModelAttribute
    public TbUser getTbUser( Integer id){
        TbUser tbUser = new TbUser();
        if (id != null){
            tbUser = userService.getById(id);
            return tbUser;
        }else
        return tbUser;
    }

    /**
     * 跳转到用户列表页
     * @param model
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(Model model){
        List<TbUser> tbUsers = userService.selectAll();
        model.addAttribute("tbUsers",tbUsers);
        return "user_list";
    }

    /**
     * 跳转到用户表单页
     * @return
     */
    @RequestMapping(value = "form",method = RequestMethod.GET)
    public  String form(){
        return "user_form";
    }

    /**
     * 用户信息保存
     * @param tbUser
     * @return
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(TbUser tbUser, RedirectAttributes redirectAttributes,Model model){
        BaseResult baseResult = userService.save(tbUser);
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/user/list";
        }
        else {
            model.addAttribute("baseResult",baseResult);
            return "user_form";
        }
    }

    @RequestMapping(value = "search",method = RequestMethod.POST)
    public String search(TbUser tbUser,Model model){
        List<TbUser> tbUsers = userService.search(tbUser);
        model.addAttribute("tbUsers",tbUsers);
        return "user_list";
    }

    /**
     * 批量删除用户信息
     * @param ids
     * @return
     */
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult delete(String ids){
        BaseResult baseResult = null;
        if (!StringUtils.isBlank(ids)) {
            String[] idsArr = ids.split(",");
            userService.deleteMulti(idsArr);
            baseResult = BaseResult.success("删除成功！");
            return baseResult;
        }
        else {
            baseResult = BaseResult.fail("删除失败！");
            return baseResult;
        }
    }
}
