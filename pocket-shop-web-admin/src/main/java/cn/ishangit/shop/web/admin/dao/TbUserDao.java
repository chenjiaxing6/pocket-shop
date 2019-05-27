package cn.ishangit.shop.web.admin.dao;

import cn.ishangit.shop.commons.persistence.BaseDao;
import cn.ishangit.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

/**
 * @author Chen
 * @create 2019-05-16 12:09
 */
@Repository
public interface TbUserDao extends BaseDao<TbUser> {

    /**
     * 根据邮箱查询用户
     * @param email
     * @return
     */
    public TbUser getByEmail(String email);
}
