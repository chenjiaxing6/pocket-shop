package cn.ishangit.shop.web.admin.service.impl;

import cn.ishangit.shop.commons.dto.BaseResult;
import cn.ishangit.shop.commons.validator.BeanValidator;
import cn.ishangit.shop.domain.TbUser;
import cn.ishangit.shop.web.admin.abstracts.AbstractBaseServiceImpl;
import cn.ishangit.shop.web.admin.dao.TbUserDao;
import cn.ishangit.shop.web.admin.service.TbUserService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;

/**
 * @author Chen
 * @create 2019-05-16 12:13
 */
@Service
public class TbUserServiceImpl extends AbstractBaseServiceImpl<TbUser,TbUserDao> implements TbUserService {


    @Override
    public TbUser login(String email, String password) {
        TbUser tbUser = dao.getByEmail(email);
        if (tbUser!= null){
            //对密码进行加密
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
            //与数据库中的密码匹配
            if (md5Password.equals(tbUser.getPassword())){
                return tbUser;
            }
        }
        return null;
    }

    @Override
    public BaseResult save(TbUser tbUser) {
        String validator = BeanValidator.validator(tbUser);
        if (validator!= null){
            //验证失败
            return BaseResult.fail(validator);
        }

        else {
            //验证成功
            tbUser.setUpdated(new Date());
            //新增
            if (tbUser.getId() == null){
                tbUser.setCreated(new Date());
                tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
                insert(tbUser);
            }
            //编辑用户
            else {
                update(tbUser);
            }
             return BaseResult.success("保存用户成功!");
        }
    }

}
