package cn.ishangit.shop.web.admin.service.impl;

import cn.ishangit.shop.domain.TbContentCategory;
import cn.ishangit.shop.web.admin.dao.TbContentCategoryDao;
import cn.ishangit.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Chen
 * @create 2019-05-20 14:34
 */
@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService {
    @Autowired
    private TbContentCategoryDao tbContentCategoryDao;

    @Override
    public List<TbContentCategory> selectAll() {
        return tbContentCategoryDao.selectAll();
    }
}
