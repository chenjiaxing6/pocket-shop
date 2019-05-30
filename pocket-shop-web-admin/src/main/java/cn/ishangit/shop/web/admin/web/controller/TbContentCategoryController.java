package cn.ishangit.shop.web.admin.web.controller;

import cn.ishangit.shop.commons.dto.BaseResult;
import cn.ishangit.shop.domain.TbContentCategory;
import cn.ishangit.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chen
 * @create 2019-05-20 14:34
 */
@Controller
@RequestMapping("content/category")
public class TbContentCategoryController{
    @Autowired
    private TbContentCategoryService contentCategoryService;

    @ModelAttribute
    public TbContentCategory getTbContentCategory(Long id){
        TbContentCategory tbContentCategory = new TbContentCategory();
        if (id != null){
            tbContentCategory = contentCategoryService.getById(id);
        }
        return tbContentCategory;
    }

    /**
     * 查询分类列表
     * @param model
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(Model model){
        List<TbContentCategory> tbContentCategories = contentCategoryService.selectAll();

        //排序
        List<TbContentCategory> sourceList = tbContentCategories;
        List<TbContentCategory> targetList = new ArrayList<>();
        sortList(sourceList,targetList,0l);

        model.addAttribute("tbContentCategories",targetList);
        return "content_category_list";
    }

    /**
     * 根据父ID查询所有子分类
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "treeData",method = RequestMethod.POST)
    public List<TbContentCategory> treeData(Long id){
        if (id == null){
            id = 0l;
        }
        return contentCategoryService.selectByPid(id);
    }

    /**
     * 跳转到表单页
     * @param tbContentCategory
     * @return
     */
    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String contentCategoryForm(TbContentCategory tbContentCategory){
        return "content_category_form";
    }

    /**
     * 保存分类信息
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(TbContentCategory tbContentCategory, Model model, RedirectAttributes redirectAttributes){
        BaseResult baseResult = contentCategoryService.save(tbContentCategory);
        //保存成功
        if (baseResult.getStatus() == 200){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/content/category/list";
        }else {
            model.addAttribute("baseResult",baseResult);
            return contentCategoryForm(tbContentCategory);
        }
    }

    /**
     * 排序
     * @param sourceList 排序前的集合
     * @param targetList 排序后的集合
     * @param parentId 父节点的id
     */
    private void sortList(List<TbContentCategory> sourceList,List<TbContentCategory> targetList,Long parentId){
        for (TbContentCategory tbContentCategory : sourceList) {
            if (tbContentCategory.getParentId().equals(parentId)){
                targetList.add(tbContentCategory);

                //判断有没有子节点
                Boolean parent = tbContentCategory.getIsParent();
                if (parent){
                    for (TbContentCategory contentCategory : sourceList) {
                        if (contentCategory.getParentId() .equals(tbContentCategory.getId())){
                            sortList(sourceList,targetList,tbContentCategory.getId());
                            break;
                        }
                    }
                }
            }
        }
    }
}
