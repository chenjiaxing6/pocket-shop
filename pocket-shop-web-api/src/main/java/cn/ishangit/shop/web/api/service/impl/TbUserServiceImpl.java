package cn.ishangit.shop.web.api.service.impl;

import cn.ishangit.shop.commons.dto.BaseResult;
import cn.ishangit.shop.domain.TbUser;
import cn.ishangit.shop.web.api.dao.TbUserDao;
import cn.ishangit.shop.web.api.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @description:
 * @author: Chen
 * @create: 2019-05-31 19:24
 **/
@Service
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    private TbUserDao tbUserDao ;

    @Override
    public BaseResult login(String email, String password) {
        TbUser tbUser = tbUserDao.login(email);
        if (tbUser!=null){
            String newPassword = DigestUtils.md5DigestAsHex(password.getBytes());
            if (newPassword.equals(tbUser.getPassword())){
                return BaseResult.success("登录成功！",tbUser);
            }
            else {
                return BaseResult.fail("用户名或密码错误！");
            }
        }
        else {
            return BaseResult.fail("用户名或密码错误！");
        }
    }
}
