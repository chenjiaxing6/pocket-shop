package cn.ishangit.shop.web.api.dao;

import cn.ishangit.shop.domain.TbContent;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: Chen
 * @create: 2019-05-30 08:50
 **/
@Repository
public interface TbContentDao {
    /**
     * 根据分类ID查询内容
     * @param tbContent
     * @return
     */
    List<TbContent> findContentByCategoryId(TbContent tbContent);
}
