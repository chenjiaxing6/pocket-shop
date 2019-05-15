package cn.ishangit.shop.web.admin.dao;

import cn.ishangit.shop.domain.User;

/**
 * @author Chen
 * @create 2019-05-15 16:15
 */
public interface UserDao {

    public User getUser(String email,String password);
}
