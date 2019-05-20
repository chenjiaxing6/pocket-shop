package cn.ishangit.shop.web.admin.dao;

import cn.ishangit.shop.domain.TbContentCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Chen
 * @create 2019-05-20 14:33
 */
@Repository
public interface TbContentCategoryDao {

    /**
     * 查询分类列表
     * @return
     */
    public List<TbContentCategory> selectAll();
}
