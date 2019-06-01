package cn.ishangit.shop.web.ui.api;

import cn.ishangit.shop.commons.constant.HttpClientUtils;
import cn.ishangit.shop.commons.constant.MapperUtils;
import cn.ishangit.shop.web.ui.dto.Content;

import java.util.List;

/**
 * @description:内容管理接口
 * @author: Chen
 * @create: 2019-05-31 17:12
 **/
public class ContentsApi {
    public static List<Content> getContentByCategoryId(Long id){
        String result = HttpClientUtils.doGet(API.API_CONTENTS+id,
                "userInfo=admin@7kjc.com:123456; Webstorm-2c8fa109=7aa6e34f-7c73-4972-81d2-0a26cc3efb2b; JSESSIONID=D1E6833EC3A82CDF2B44E5447589CCBD");
        List<Content> contents = null;
        try {
            contents = MapperUtils.json2listByTree(result.toString(), Content.class,"data");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contents;
    }
}
