package cn.ishangit.shop.web.admin.dao;

import cn.ishangit.shop.domain.TbContent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Chen
 * @create 2019-05-21 12:23
 */
@Repository
public interface TbContentDao {
    /**
     * 查询内容表全部信息
     * @return
     */
    public List<TbContent>  selectAll();


    /**
     * 插入内容
     * @param tbContent
     */
    public void insertTbContent(TbContent tbContent);

    /**
     * 更新内容
     * @param tbContent
     */
    public void updateTbContent(TbContent tbContent);

    /**
     * 根据id查询内容
     * @param id
     * @return
     */
    public TbContent getById(Integer id);


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
    public List<TbContent> page(Map<String,Object> param);

    /**
     * 查询总记录数
     * @return
     */
    public Integer count(TbContent tbContent);
}
