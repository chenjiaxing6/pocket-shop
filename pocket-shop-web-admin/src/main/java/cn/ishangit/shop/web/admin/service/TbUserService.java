package cn.ishangit.shop.web.admin.service;

import cn.ishangit.shop.domain.TbUser;

import java.util.List;

/**
 * @author Chen
 * @create 2019-05-16 12:12
 */
public interface TbUserService {
    /**
     * 查询用户表全部信息
     * @return
     */
    public List<TbUser> selectAll();
}
