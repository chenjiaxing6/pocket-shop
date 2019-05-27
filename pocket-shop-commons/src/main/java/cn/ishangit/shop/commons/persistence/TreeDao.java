package cn.ishangit.shop.commons.persistence;

import java.util.List;

/**
 * @author Chen
 * @create 2019-05-27 14:21
 * 树形菜单通用dao接口
 */
public interface TreeDao<T extends BaseEntity> {
    /**
     * 查询全部信息
     * @return
     */
    public List<T> selectAll();

    /**
     * 根据父节点id查询所有子节点
     */
    public List<T> selectByPid(Long pid);


    /**
     * 插入
     * @param entity
     */
    public void insert(T entity);

    /**
     * 更新
     * @param entity
     */
    public void update(T entity);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public T getById(Integer id);


    /**
     * 批量删除
     * @param ids
     */
    public void deleteMulti(String[] ids);

}
