package cn.ishangit.shop.web.admin.abstracts;

import cn.ishangit.shop.commons.persistence.BaseEntity;
import cn.ishangit.shop.commons.persistence.TreeDao;
import cn.ishangit.shop.commons.persistence.TreeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @description: 类描述
 * @author: Chen
 * @create: 2019-05-27 20:50
 **/
public abstract class AbstractBaseTreeServiceImpl<T extends BaseEntity,D extends TreeDao<T>> implements TreeService<T> {
    @Autowired
    private D dao;

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
     * 删除
     * @param ids
     */
    @Override
    public void deleteMulti(String[] ids) {
        dao.deleteMulti(ids);
    }

    /**
     * 根据父级分类查询
     * @param pid
     * @return
     */
    @Override
    public List<T> selectByPid(Long pid) {
        return dao.selectByPid(pid);
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
