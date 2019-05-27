package cn.ishangit.shop.web.admin.abstracts;

import cn.ishangit.shop.commons.dto.PageInfo;
import cn.ishangit.shop.commons.persistence.BaseDao;
import cn.ishangit.shop.commons.persistence.BaseEntity;
import cn.ishangit.shop.commons.persistence.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 业务层统一实现类
 * @author: Chen
 * @create: 2019-05-27 21:18
 **/
public abstract class AbstractBaseServiceImpl<T extends BaseEntity,D extends BaseDao<T>>implements BaseService<T>{

    @Autowired
    protected D dao;

    /**
     * 查询全部
     * @return
     */
    @Override
    public List<T> selectAll() {
        return dao.selectAll();
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public T getById(Long id) {
        return dao.getById(id.intValue());
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void deleteMulti(String[] ids) {
        dao.deleteMulti(ids);
    }

    /**
     * 查询总数
     * @param entity
     * @return
     */
    @Override
    public Integer count(T entity) {
        return dao.count(entity);
    }

    /**
     * 分页查询
     * @param length
     * @param start
     * @param draw
     * @param entity
     * @return
     */
    @Override
    public PageInfo<T> page(Integer length, Integer start, Integer draw, T entity) {
        PageInfo<T> pageInfo = new PageInfo();

        Map<String,Object> param = new HashMap<>();
        param.put("length",length);
        param.put("start",start);
        param.put("baseParams",entity);

        pageInfo.setDraw(draw);
        pageInfo.setData(dao.page(param));
        pageInfo.setRecordsTotal(dao.count(entity));
        pageInfo.setRecordsFiltered(dao.count(entity));

        return pageInfo;
    }

    /**
     * 更新
     */
    public void update(T entity){
        dao.update(entity);
    }

    /**
     * 保存
     */
    public void insert(T entity){
        dao.insert(entity);
    }
}
