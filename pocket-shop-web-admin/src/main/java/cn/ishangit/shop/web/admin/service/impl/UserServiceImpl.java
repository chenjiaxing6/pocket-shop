package cn.ishangit.shop.web.admin.service.impl;

import cn.ishangit.shop.domain.User;
import cn.ishangit.shop.web.admin.dao.UserDao;
import cn.ishangit.shop.web.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Chen
 * @create 2019-05-15 16:27
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User login(String email, String password) {
        return userDao.getUser(email,password);
    }
}
