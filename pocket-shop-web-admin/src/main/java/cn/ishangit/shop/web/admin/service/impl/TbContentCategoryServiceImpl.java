package cn.ishangit.shop.web.admin.service.impl;

import cn.ishangit.shop.commons.dto.BaseResult;
import cn.ishangit.shop.commons.validator.BeanValidator;
import cn.ishangit.shop.domain.TbContentCategory;
import cn.ishangit.shop.web.admin.abstracts.AbstractBaseTreeServiceImpl;
import cn.ishangit.shop.web.admin.dao.TbContentCategoryDao;
import cn.ishangit.shop.web.admin.service.TbContentCategoryService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Chen
 * @create 2019-05-20 14:34
 */
@Service
public class TbContentCategoryServiceImpl extends AbstractBaseTreeServiceImpl<TbContentCategory,TbContentCategoryDao> implements TbContentCategoryService {

    @Override
    public BaseResult save(TbContentCategory entity) {
        String validator = BeanValidator.validator(entity);
        if (validator != null){
            //验证失败
            return  BaseResult.fail(validator);
        }
        //验证成功
        else {
            //如果没有选择结点默认为根结点
            TbContentCategory parent = entity.getParent();
            if (parent == null || parent.getId() == null){
                parent.setId(0l);
                entity.setIsParent(true);
            }

            entity.setUpdated(new Date());
            //新增
            if (entity.getId() == null){
                entity.setCreated(new Date());
                entity.setIsParent(false);

                //判断有无父级结点，如果有，设置isparent为true
                if (parent.getId() != 0){
                    TbContentCategory currentCategoryParent = getById(parent.getId());
                    if (currentCategoryParent!= null){
                        currentCategoryParent.setIsParent(true);
                        update(currentCategoryParent);
                    }
                }
                insert(entity);
                return BaseResult.success("新增分类信息成功!");
            }
            //修改
            else {
                update(entity);
                return BaseResult.success("更新分类信息成功!");
            }
        }
    }


}
