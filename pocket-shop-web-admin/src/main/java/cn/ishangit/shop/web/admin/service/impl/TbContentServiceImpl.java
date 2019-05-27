package cn.ishangit.shop.web.admin.service.impl;

import cn.ishangit.shop.commons.dto.BaseResult;
import cn.ishangit.shop.commons.validator.BeanValidator;
import cn.ishangit.shop.domain.TbContent;
import cn.ishangit.shop.web.admin.abstracts.AbstractBaseServiceImpl;
import cn.ishangit.shop.web.admin.dao.TbContentDao;
import cn.ishangit.shop.web.admin.service.TbContentService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Chen
 * @create 2019-05-21 12:24
 */
@Service
public class TbContentServiceImpl extends AbstractBaseServiceImpl<TbContent,TbContentDao> implements TbContentService {


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
                insert(tbContent);
                return BaseResult.success("保存内容成功");
            }
            //编辑
            else {
                update(tbContent);
                return BaseResult.success("更新内容成功");
            }

        }
    }

}
