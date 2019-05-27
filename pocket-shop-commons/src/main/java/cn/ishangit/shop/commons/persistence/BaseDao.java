package cn.ishangit.shop.commons.persistence;

import java.util.List;
import java.util.Map;

/**
 * @author Chen
 * @create 2019-05-25 11:34
 * 数据访问层封装
 */
public interface BaseDao<T extends BaseEntity>{
    /**
     * 查询全部信息
     * @return
     */
    public List<T> selectAll();


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


    /**
     * 分页查询
     * @param param：需要传入start：数据开始的位置 length：每页的记录数
     * @return
     */
    public List<T> page(Map<String,Object> param);

    /**
     * 查询总记录数
     * @return
     */
    public Integer count(T entity);
}
