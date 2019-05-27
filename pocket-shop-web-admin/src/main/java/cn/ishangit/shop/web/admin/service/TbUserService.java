package cn.ishangit.shop.web.admin.service;

import cn.ishangit.shop.commons.persistence.BaseService;
import cn.ishangit.shop.domain.TbUser;

/**
 * @author Chen
 * @create 2019-05-16 12:12
 */
public interface TbUserService extends BaseService<TbUser> {

    /**
     * 登录
     */
    public TbUser login(String email,String password);
}
