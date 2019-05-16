package cn.ishangit.shop.web.admin.dao;

import cn.ishangit.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Chen
 * @create 2019-05-16 12:09
 */
@Repository
public interface TbUserDao {
    /**
     * 查询用户表全部信息
     * @return
     */
    public List<TbUser>  selectAll();
}
