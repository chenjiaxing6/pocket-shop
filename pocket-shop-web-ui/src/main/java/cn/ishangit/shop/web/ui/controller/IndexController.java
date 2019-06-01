package cn.ishangit.shop.web.ui.controller;

import cn.ishangit.shop.web.ui.api.ContentsApi;
import cn.ishangit.shop.web.ui.dto.Content;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @description:
 * @author: Chen
 * @create: 2019-05-30 15:46
 **/
@Controller
public class IndexController {

    /**
     * 跳转到首页
     * @return
     */
    @RequestMapping(value = "index",method = RequestMethod.GET)
    public  String Index(Model model){
        ObjectMapper objectMapper = new ObjectMapper();
        //获取幻灯片
        List<Content> contents = getppt();
        model.addAttribute("ppt",contents);
        return "index";
    }

    /**
     * 获取幻灯片
     */
    private List<Content> getppt(){
        return ContentsApi.getContentByCategoryId(121l);
    }

}
