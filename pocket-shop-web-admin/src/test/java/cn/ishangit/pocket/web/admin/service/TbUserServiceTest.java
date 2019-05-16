package cn.ishangit.pocket.web.admin.service;

import cn.ishangit.shop.domain.TbUser;
import cn.ishangit.shop.web.admin.service.TbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.util.List;

/**
 * @author Chen
 * @create 2019-05-16 12:20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-context-druid.xml","classpath:spring-context-mybatis.xml"})
public class TbUserServiceTest {
    @Autowired
    private TbUserService userService;

    @Test
    public void testSlectAll(){
        List<TbUser> tbUsers = userService.selectAll();
        for (TbUser tbUser : tbUsers) {
            System.out.println(tbUser.getUsername());
        }
    }

    @Test
    public void testMd5(){
        String password = "123456";
        String s = DigestUtils.md5DigestAsHex(password.getBytes());
        System.out.println(s);
    }
}
