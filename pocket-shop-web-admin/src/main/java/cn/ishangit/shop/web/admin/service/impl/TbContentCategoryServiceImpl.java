package cn.ishangit.shop.web.admin.service.impl;

import cn.ishangit.shop.commons.dto.BaseResult;
import cn.ishangit.shop.commons.validator.BeanValidator;
import cn.ishangit.shop.domain.TbContentCategory;
import cn.ishangit.shop.web.admin.dao.TbContentCategoryDao;
import cn.ishangit.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
                        tbContentCategoryDao.update(currentCategoryParent);
                    }
                }
                tbContentCategoryDao.insert(entity);
                return BaseResult.success("新增分类信息成功!");
            }
            //修改
            else {
                tbContentCategoryDao.update(entity);
                return BaseResult.success("更新分类信息成功!");
            }
        }
    }

    @Override
    public TbContentCategory getById(Long id) {
        return tbContentCategoryDao.getById(id.intValue());
    }

    @Override
    public void deleteMulti(String[] ids) {
        tbContentCategoryDao.deleteMulti(ids);
    }


    @Override
    public List<TbContentCategory> selectByPid(Long pid) {
        return tbContentCategoryDao.selectByPid(pid);
    }

}
