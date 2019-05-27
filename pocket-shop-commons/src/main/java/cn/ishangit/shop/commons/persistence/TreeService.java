package cn.ishangit.shop.commons.persistence;

import cn.ishangit.shop.commons.dto.BaseResult;

import java.util.List;

/**
 * @author Chen
 * @create 2019-05-27 14:26
 * 树形菜单通用service接口
 */
public interface TreeService<T extends BaseEntity>{
    /**
     * 查全部
     * @return
     */
    public List<T> selectAll();

    /**
     * 根据父节点id查询所有子节点
     */
    public List<T> selectByPid(Long pid);


    /**
     * 保存
     * @param entity
     */
    public BaseResult save(T entity);


    /**
     * 根据id查询
     * @param id
     * @return
     */
    public T getById(Long id);


    /**
     * 批量删除
     * @param ids
     */
    public void deleteMulti(String[] ids);
}
