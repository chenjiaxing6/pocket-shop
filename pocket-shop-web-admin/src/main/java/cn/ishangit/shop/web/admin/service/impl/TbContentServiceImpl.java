package cn.ishangit.shop.web.admin.service.impl;

import cn.ishangit.shop.commons.dto.BaseResult;
import cn.ishangit.shop.commons.dto.PageInfo;
import cn.ishangit.shop.domain.TbContent;
import cn.ishangit.shop.web.admin.dao.TbContentDao;
import cn.ishangit.shop.web.admin.service.TbContentService;
import org.apache.commons.lang3.StringUtils;
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
        //检验有效性
        BaseResult baseResult = checkTbContent(tbContent);
        //通过验证
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS){
            tbContent.setUpdated(new Date());
            //新增
            if (tbContent.getId() == null){
                tbContent.setCreated(new Date());
                tbContentDao.insertTbContent(tbContent);
            }
            //编辑
            else {
                tbContentDao.updateTbContent(tbContent);
            }
            baseResult.setMessage("保存内容成功！");
        }
        return baseResult;
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

    /**
     * 内容信息有效性验证
     */
    public BaseResult checkTbContent(TbContent tbContent){
        BaseResult baseResult = BaseResult.success();
        //非空验证
        if (StringUtils.isBlank(tbContent.getCategoryId().toString())){
            return BaseResult.fail("内容分类不能为空，请重新输入");
        }
        else if (StringUtils.isBlank(tbContent.getTitle())){
            return BaseResult.fail("内容标题不能为空，请重新输入");
        }
        else if (StringUtils.isBlank(tbContent.getSubTitle())){
            return BaseResult.fail("内容二级标题不能为空，请重新输入");
        }
        return baseResult;
    }
}
