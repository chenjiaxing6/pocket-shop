package cn.ishangit.shop.web.admin.web.controller;

import cn.ishangit.shop.domain.TbContentCategory;
import cn.ishangit.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chen
 * @create 2019-05-20 14:34
 */
@Controller
@RequestMapping("content/category")
public class TbContentCategoryController {
    @Autowired
    private TbContentCategoryService contentCategoryService;

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
                if (tbContentCategory.isParent()){
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
