package cn.ishangit.shop.commons.persistence;

import cn.ishangit.shop.commons.dto.BaseResult;
import cn.ishangit.shop.commons.dto.PageInfo;

import java.util.List;

/**
 * @author Chen
 * @create 2019-05-25 11:37
 * 封装所有的业务逻辑层
 */
public interface BaseService<T extends BaseEntity> {
    /**
     * 查全部
     * @return
     */
    public List<T> selectAll();


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


    /**
     * 分页查询
     * @return
     */
    public PageInfo<T> page(Integer length, Integer start, Integer draw, T entity);

    /**
     * 查询总记录数
     * @return
     */
    public Integer count(T entity);

}
