package cn.ishangit.shop.web.admin.web.controller;

import cn.ishangit.shop.commons.dto.BaseResult;
import cn.ishangit.shop.commons.dto.PageInfo;
import cn.ishangit.shop.domain.TbContent;
import cn.ishangit.shop.web.admin.service.TbContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Chen
 * @create 2019-05-21 12:24
 */
@Controller
@RequestMapping(value = "content")
public class TbContentController {
    @Autowired
    private TbContentService tbContentService;

    @ModelAttribute
    public TbContent getTbContent(Integer id){
        TbContent tbContent = new TbContent();
        if (id != null){
            tbContent = tbContentService.getById(id);
            return tbContent;
        }else
            return tbContent;
    }

    /**
     * 跳转到内容列表页
     * @param model
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(Model model){
        return "content_list";
    }

    /**
     * 跳转到内容表单页
     * @return
     */
    @RequestMapping(value = "form",method = RequestMethod.GET)
    public  String form(){
        return "content_form";
    }

    /**
     * 内容信息保存
     * @param tbContent
     * @return
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(TbContent tbContent, RedirectAttributes redirectAttributes, Model model){
        BaseResult baseResult = tbContentService.save(tbContent);
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/content/list";
        }
        else {
            model.addAttribute("baseResult",baseResult);
            return "content_form";
        }
    }


    /**
     * 批量删除内容信息
     * @param ids
     * @return
     */
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult delete(String ids){
        BaseResult baseResult = null;
        if (!StringUtils.isBlank(ids)) {
            String[] idsArr = ids.split(",");
            tbContentService.deleteMulti(idsArr);
            baseResult = BaseResult.success("删除成功！");
            return baseResult;
        }
        else {
            baseResult = BaseResult.fail("删除失败！");
            return baseResult;
        }
    }

    /**
     * 分页查询
     * @param request
     * @param tbContent
     * @return
     */
    @RequestMapping(value = "page",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<TbContent> page(HttpServletRequest request, TbContent tbContent){
        Map<String, Object> res = new HashMap<>();

        String str_draw = request.getParameter("draw");
        String str_start = request.getParameter("start");
        String str_length = request.getParameter("length");

        int draw = str_draw  == null?0: Integer.parseInt(str_draw);
        int start = str_start  == null?0: Integer.parseInt(str_start);
        int length = str_length  == null?10: Integer.parseInt(str_length);
        PageInfo<TbContent> pageInfo = tbContentService.page(length, start,draw,tbContent);

        return pageInfo;
    }

    /**
     * 用户详情
     * @param tbContent
     * @return
     */
    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public String detail(TbContent tbContent){
        return "content_detail";
    }
}
