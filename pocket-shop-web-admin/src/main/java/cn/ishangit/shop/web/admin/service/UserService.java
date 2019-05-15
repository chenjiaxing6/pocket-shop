package cn.ishangit.shop.web.admin.service;

import cn.ishangit.shop.domain.User;

/**
 * @author Chen
 * @create 2019-05-15 16:26
 */
public interface UserService {

    public User login(String email,String password);
}
