package cn.ishangit.shop.web.admin.service.impl;

import cn.ishangit.shop.commons.dto.BaseResult;
import cn.ishangit.shop.commons.dto.PageInfo;
import cn.ishangit.shop.commons.validator.BeanValidator;
import cn.ishangit.shop.domain.TbContent;
import cn.ishangit.shop.web.admin.dao.TbContentDao;
import cn.ishangit.shop.web.admin.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Chen
 * @create 2019-05-21 12:24
 */
@Service
public class TbContentServiceImpl implements TbContentService {

    @Autowired
    private TbContentDao tbContentDao;

    @Override
    public List<TbContent> selectAll() {
        return tbContentDao.selectAll();
    }

    @Override
    public BaseResult save(TbContent tbContent) {
        String validator = BeanValidator.validator(tbContent);
        if (validator != null){
            return BaseResult.fail(validator);
        }

        else {
            tbContent.setUpdated(new Date());
            //新增
            if (tbContent.getId() == null){
                tbContent.setCreated(new Date());
                tbContentDao.insertTbContent(tbContent);
                return BaseResult.success("更新内容成功");
            }
            //编辑
            else {
                tbContentDao.updateTbContent(tbContent);
            }
            return BaseResult.success("保存内容成功");

        }
    }

    @Override
    public TbContent getById(Integer id) {
        return tbContentDao.getById(id);
    }

    @Override
    public void deleteMulti(String[] ids) {
        tbContentDao.deleteMulti(ids);
    }

    @Override
    public PageInfo<TbContent> page(Integer length, Integer start, Integer draw, TbContent tbContent) {
        PageInfo<TbContent> pageInfo = new PageInfo();

        Map<String,Object> param = new HashMap<>();
        param.put("length",length);
        param.put("start",start);
        param.put("tbContent",tbContent);

        pageInfo.setDraw(draw);
        pageInfo.setData(tbContentDao.page(param));
        pageInfo.setRecordsTotal(tbContentDao.count(tbContent));
        pageInfo.setRecordsFiltered(tbContentDao.count(tbContent));

        return pageInfo;
    }

    @Override
    public Integer count(TbContent tbContent) {
        return tbContentDao.count(tbContent);
    }
}
