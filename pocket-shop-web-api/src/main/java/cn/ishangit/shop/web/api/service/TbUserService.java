package cn.ishangit.shop.web.api.service;

import cn.ishangit.shop.commons.dto.BaseResult;

/**
 * @description:
 * @author: Chen
 * @create: 2019-05-31 19:23
 **/
public interface TbUserService {
    public BaseResult login(String email , String password);
}
