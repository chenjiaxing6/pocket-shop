package cn.ishangit.shop.domain;

import cn.ishangit.shop.commons.constant.RegexUtils;
import cn.ishangit.shop.commons.persistence.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

/**
 * @author Chen
 * @create 2019-05-16 12:06
 */
@Data
public class TbUser extends BaseEntity {
    @Length(min = 6,max = 20,message = "用户名长度必须在6-20位之间")
    private  String username;
    @JsonIgnore
    @Length(min = 6,max = 20,message = "密码长度必须在6-20位之间")
    private  String password;
    @Pattern(regexp = RegexUtils.PHONE,message = "手机格式不符合要求")
    private  String phone ;
    @Pattern(regexp = RegexUtils.EMAIL,message = "邮箱格式不符合要求")
    private  String email;
}
