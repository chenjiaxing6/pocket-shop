package cn.ishangit.shop.web.api.dao;

import cn.ishangit.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: Chen
 * @create: 2019-05-31 19:07
 **/
@Repository
public interface TbUserDao {

    /**
     * 根据邮箱查询用户
     * @param email
     * @return
     */
    public TbUser login(String email);
}
