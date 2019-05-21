package cn.ishangit.shop.web.admin.service;

import cn.ishangit.shop.commons.dto.BaseResult;
import cn.ishangit.shop.commons.dto.PageInfo;
import cn.ishangit.shop.domain.TbContent;

import java.util.List;

/**
 * @author Chen
 * @create 2019-05-21 12:24
 */
public interface TbContentService {
    /**
     * 查询内容表全部信息
     * @return
     */
    public List<TbContent>  selectAll();


    /**
     * 保存内容
     * @param tbContent
     */
    public BaseResult save(TbContent tbContent);


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
     * @return
     */
    public PageInfo<TbContent> page(Integer length, Integer start, Integer draw, TbContent tbContent);

    /**
     * 查询总记录数
     * @return
     */
    public Integer count(TbContent tbContent);
}
