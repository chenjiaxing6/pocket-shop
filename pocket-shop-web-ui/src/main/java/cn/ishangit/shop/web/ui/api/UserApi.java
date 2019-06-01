package cn.ishangit.shop.web.ui.api;

import cn.ishangit.shop.commons.constant.HttpClientUtils;
import cn.ishangit.shop.commons.constant.MapperUtils;
import cn.ishangit.shop.web.ui.dto.User;
import cn.ishangit.shop.web.ui.dto.UserDto;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:用户管理接口
 * @author: Chen
 * @create: 2019-05-31 22:11
 **/

public class UserApi {

    public static UserDto login(User user) throws Exception {
        //设置post请求参数
        List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
        params.add(new BasicNameValuePair("email",user.getEmail()));
        params.add(new BasicNameValuePair("password",user.getPassword()));
        //发送post请求
        String json = HttpClientUtils.doPost(API.API_USERS + "login", params.toArray(new BasicNameValuePair[params.size()]));
        //将请求中的data数据转换为pojo
        User user1 = MapperUtils.json2pojoByTree(json, User.class, "data");
        //把user1中的字段copy到dto中
        if (user1 != null) {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(user1, userDto);
            return userDto;
        }
        return null;
    }
}
