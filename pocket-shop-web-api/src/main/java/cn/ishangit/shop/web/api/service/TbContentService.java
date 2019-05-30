package cn.ishangit.shop.web.api.service;

import cn.ishangit.shop.domain.TbContent;

import java.util.List;

/**
 * @description:
 * @author: Chen
 * @create: 2019-05-30 08:52
 **/
public interface TbContentService {
    /**
     * 根据分类ID查询内容
     * @param contentCategoryId
     * @return
     */
    List<TbContent> findContentByCategoryId(Long contentCategoryId);
}
