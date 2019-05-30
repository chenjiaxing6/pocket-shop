package cn.ishangit.shop.web.admin.abstracts;

import cn.ishangit.shop.commons.dto.BaseResult;
import cn.ishangit.shop.commons.dto.PageInfo;
import cn.ishangit.shop.commons.persistence.BaseEntity;
import cn.ishangit.shop.commons.persistence.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: 通用Controller层封装
 * @author: Chen
 * @create: 2019-05-27 22:19
 **/
public abstract class AbstractBaseController<T extends BaseEntity,S extends BaseService<T>> {

    @Autowired
    protected  S service;

    /**
     * 跳转到列表页
     * @param model
     * @return
     */
    public abstract String list(Model model);

    /**
     * 跳转到表单页
     * @return
     */
    public abstract String form();

    /**
     * 信息保存
     * @param entity
     * @return
     */
    public abstract String save(T entity, RedirectAttributes redirectAttributes, Model model);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    public abstract BaseResult delete(String ids);


    /**
     * 分页查询
     * @param request
     * @param entity
     * @return
     */
    public abstract PageInfo<T> page(HttpServletRequest request, T entity);

    /**
     * 详情
     * @param entity
     * @return
     */
    public abstract String detail(T entity);

}
