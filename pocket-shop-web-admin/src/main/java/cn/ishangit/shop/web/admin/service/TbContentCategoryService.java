package cn.ishangit.shop.web.admin.service;

import cn.ishangit.shop.domain.TbContentCategory;

import java.util.List;

/**
 * @author Chen
 * @create 2019-05-20 14:33
 */
public interface TbContentCategoryService {
    /**
     * 查询分类列表
     * @return
     */
    public List<TbContentCategory> selectAll();
    /**
     * 根据父节点id查询所有子节点
     */
    public List<TbContentCategory> selectByPid(Long pid);
}
