package cn.ishangit.shop.web.api.web.controller.v1;

import cn.ishangit.shop.commons.dto.BaseResult;
import cn.ishangit.shop.web.api.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Chen
 * @create: 2019-05-31 19:43
 **/
@RestController
@RequestMapping("${api.path.v1}/users")
public class TbUserController {
    @Autowired
    private TbUserService userService;

    /**
     * 登录
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public BaseResult login(String email,String password){
        BaseResult baseResult = userService.login(email, password);
        return baseResult;
    }
}
