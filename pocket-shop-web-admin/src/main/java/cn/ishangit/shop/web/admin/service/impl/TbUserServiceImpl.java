package cn.ishangit.shop.web.admin.service.impl;

import cn.ishangit.shop.commons.dto.BaseResult;
import cn.ishangit.shop.commons.dto.PageInfo;
import cn.ishangit.shop.commons.validator.BeanValidator;
import cn.ishangit.shop.domain.TbUser;
import cn.ishangit.shop.web.admin.dao.TbUserDao;
import cn.ishangit.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public TbUser login(String email, String password) {
        TbUser tbUser = tbUserDao.getByEmail(email);
        if (tbUser!= null){
            //对密码进行加密
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
            //与数据库中的密码匹配
            if (md5Password.equals(tbUser.getPassword())){
                return tbUser;
            }
        }
        return null;
    }

    @Override
    public BaseResult save(TbUser tbUser) {
        String validator = BeanValidator.validator(tbUser);
        if (validator!= null){
            //验证失败
            return BaseResult.fail(validator);
        }

        else {
            //验证成功
            tbUser.setUpdated(new Date());
            //新增
            if (tbUser.getId() == null){
                tbUser.setCreated(new Date());
                tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
                tbUserDao.insert(tbUser);
            }
            //编辑用户
            else {
                tbUserDao.update(tbUser);
            }
             return BaseResult.success("保存用户成功!");
        }
    }

    @Override
    public TbUser getById(Long id) {
        return tbUserDao.getById(id.intValue());
    }


    @Override
    public void deleteMulti(String[] ids) {
        tbUserDao.deleteMulti(ids);
    }

    @Override
    public PageInfo<TbUser> page(Integer length, Integer start,Integer draw,TbUser tbUser) {
        PageInfo<TbUser> pageInfo = new PageInfo();

        Map<String,Object> param = new HashMap<>();
        param.put("length",length);
        param.put("start",start);
        param.put("tbUser",tbUser);

        pageInfo.setDraw(draw);
        pageInfo.setData(tbUserDao.page(param));
        pageInfo.setRecordsTotal(tbUserDao.count(tbUser));
        pageInfo.setRecordsFiltered(tbUserDao.count(tbUser));

        return pageInfo;
    }

    @Override
    public Integer count(TbUser tbUser) {
        return tbUserDao.count(tbUser);
    }

}
