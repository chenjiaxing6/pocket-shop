package cn.ishangit.shop.web.ui.dto;

import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: Chen
 * @create: 2019-05-31 22:17
 **/
@Data
public class User {
    private Long id;
    private  String username;
    private  String password;
    private  String phone ;
    private  String email;
    private Date created;
    private Date updated;
    private String verification;
}
