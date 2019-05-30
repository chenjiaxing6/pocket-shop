package cn.ishangit.shop.web.api.service;

import cn.ishangit.shop.domain.TbContent;
import cn.ishangit.shop.domain.TbContentCategory;
import cn.ishangit.shop.web.api.dao.TbContentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Chen
 * @create: 2019-05-30 08:56
 **/
@Service
public class TbContentServiceImpl implements TbContentService{

    @Autowired
    private TbContentDao tbContentDao;

    @Override
    public List<TbContent> findContentByCategoryId(Long contentCategoryId) {
        TbContentCategory tbContentCategory = new TbContentCategory();
        tbContentCategory.setId(contentCategoryId);
        TbContent tbContent = new TbContent();
        tbContent.setTbContentCategory(tbContentCategory);
        return tbContentDao.findContentByCategoryId(tbContent);
    }
}
