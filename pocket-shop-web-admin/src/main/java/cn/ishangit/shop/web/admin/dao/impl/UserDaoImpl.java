package cn.ishangit.shop.web.admin.dao.impl;

import cn.ishangit.shop.domain.User;
import cn.ishangit.shop.web.admin.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @author Chen
 * @create 2019-05-15 16:16
 */
@Repository
public class UserDaoImpl implements UserDao {
    private  static  final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public User getUser(String email, String password) {
        logger.debug("调用getUser，email:{} password:{}",email,password);
        User user = null;
        if ("admin@7kjc.com".equals(email)){
            if ("admin".equals(password)){
                user = new User();
                user.setUsername("chen");
                user.setEmail("admin@7kjc.com");

                logger.info("成功获取\"{}\"的用户信息",user.getUsername());
            }
        }else {
            logger.info("获取\"{}\"的用户信息失败",user.getEmail());
        }
        return user;
    }
}
