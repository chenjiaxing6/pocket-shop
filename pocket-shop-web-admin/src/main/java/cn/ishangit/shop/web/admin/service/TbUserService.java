package cn.ishangit.shop.web.admin.service;

import cn.ishangit.shop.commons.dto.BaseResult;
import cn.ishangit.shop.commons.dto.PageInfo;
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

    /**
     * 登录
     */
    public TbUser login(String email,String password);

    /**
     * 保存用户信息
     */
    public BaseResult save(TbUser tbUser);

    /**
     * 根据id查询用户信息
     */
    public TbUser getById(Integer id);

    /**
     * 批量删除
     * @param ids
     */
    public void  deleteMulti(String[] ids);

    /**
     * 分页查询
     * @param length
     * @param start
     * @return
     */
    public PageInfo<TbUser> page(Integer length, Integer start,Integer draw,TbUser tbUser);

    /**
     * 查询总记录数
     * @return
     */
    public Integer count(TbUser tbUser);
}
