package cn.ishangit.shop.web.admin.service.impl;

import cn.ishangit.shop.domain.TbUser;
import cn.ishangit.shop.web.admin.dao.TbUserDao;
import cn.ishangit.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Chen
 * @create 2019-05-16 12:13
 */
@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserDao tbUserDao;

    @Override
    public List<TbUser> selectAll() {
        return tbUserDao.selectAll();
    }
}
