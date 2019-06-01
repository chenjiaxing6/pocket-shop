package cn.ishangit.shop.web.api.web.controller.v1;

import cn.ishangit.shop.commons.dto.BaseResult;
import cn.ishangit.shop.domain.TbContent;
import cn.ishangit.shop.web.api.service.TbContentService;
import cn.ishangit.shop.web.api.web.dto.TbContentDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Chen
 * @create: 2019-05-30 08:57
 **/
@RestController
@RequestMapping("${api.path.v1}/contents")
public class TbContentController {
    @Autowired
    private TbContentService tbContentService;

    /**
     * 根据分类ID获取内容
     * @param categoryId
     * @return
     */
    @RequestMapping(value = "{categoryId}",method = RequestMethod.GET)
    public BaseResult getTbContentCategoryById(@PathVariable(value = "categoryId") Long categoryId){
        List<TbContent> tbContents = tbContentService.findContentByCategoryId(categoryId);
        List<TbContentDTO> tbContentDTOS = null;
        if (tbContents != null && tbContents.size()>0 ) {
            tbContentDTOS = new ArrayList<>();
            for (TbContent tbContent : tbContents) {
                TbContentDTO tbContentDTO = new TbContentDTO();
                BeanUtils.copyProperties(tbContent,tbContentDTO);
                tbContentDTOS.add(tbContentDTO);
            }
        }
        return BaseResult.success("成功",tbContentDTOS);
    }


}
