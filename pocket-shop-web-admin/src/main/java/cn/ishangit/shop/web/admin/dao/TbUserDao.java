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

    /**
     * 根据邮箱查询用户
     * @param email
     * @return
     */
    public TbUser getByEmail(String email);

    /**
     * 插入用户
     * @param tbUser
     */
    public void insertTbUser(TbUser tbUser);

    /**
     * 删除用户
     * @param tbUser
     */
    public void updateTbUser(TbUser tbUser);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    public TbUser getById(Integer id);

    /**
     * 搜索
     * @return
     */
    public List<TbUser> search(TbUser tbUser);

    /**
     * 批量删除
     * @param ids
     */
    public void deleteMulti(String[] ids);
}
