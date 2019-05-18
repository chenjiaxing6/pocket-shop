package cn.ishangit.shop.web.admin.service.impl;

import cn.ishangit.shop.commons.constant.RegexUtils;
import cn.ishangit.shop.commons.dto.BaseResult;
import cn.ishangit.shop.commons.dto.PageInfo;
import cn.ishangit.shop.domain.TbUser;
import cn.ishangit.shop.web.admin.dao.TbUserDao;
import cn.ishangit.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
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
        //检验有效性
        BaseResult baseResult = checkTbUser(tbUser);
        //通过验证
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS){
            tbUser.setUpdated(new Date());
            //新增
            if (tbUser.getId() == null){
                tbUser.setCreated(new Date());
                tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
                tbUserDao.insertTbUser(tbUser);
            }
            //编辑用户
            else {
                tbUserDao.updateTbUser(tbUser);
            }
            baseResult.setMessage("保存用户成功！");
        }
       return baseResult;
    }

    @Override
    public TbUser getById(Integer id) {
        return tbUserDao.getById(id);
    }

    @Override
    public  List<TbUser> search(TbUser tbUser) {
        return tbUserDao.search(tbUser);
    }

    @Override
    public void deleteMulti(String[] ids) {
        tbUserDao.deleteMulti(ids);
    }

    @Override
    public PageInfo<TbUser> page(Integer length, Integer start,Integer draw) {
        PageInfo<TbUser> pageInfo = new PageInfo();

        Map<String,Object> param = new HashMap<>();
        param.put("length",length);
        param.put("start",start);

        pageInfo.setDraw(draw);
        pageInfo.setData(tbUserDao.page(param));
        pageInfo.setRecordsTotal(tbUserDao.count());
        pageInfo.setRecordsFiltered(tbUserDao.count());

        return pageInfo;
    }

    @Override
    public Integer count() {
        return tbUserDao.count();
    }

    /**
     * 用户信息有效性验证
     */
    public BaseResult checkTbUser(TbUser tbUser){
        BaseResult baseResult = BaseResult.success();
        //非空验证
        if (StringUtils.isBlank(tbUser.getEmail())){
            return BaseResult.fail("用户邮箱不能为空，请重新输入");
        }
        else if (!RegexUtils.checkEmail(tbUser.getEmail())){
            return BaseResult.fail("用户邮箱格式不正确，请重新输入");
        }
        else if (StringUtils.isBlank(tbUser.getPassword())){
            return BaseResult.fail("用户密码不能为空，请重新输入");
        }
        else if (StringUtils.isBlank(tbUser.getUsername())){
            return BaseResult.fail("用户姓名不能为空，请重新输入");
        }
        else if (StringUtils.isBlank(tbUser.getPhone())){
            return BaseResult.fail("用户手机不能为空，请重新输入");
        }
        else if(!RegexUtils.checkPhone(tbUser.getPhone())){
            return BaseResult.fail("用户手机格式不正确，请重新输入");
        }
        return baseResult;
    }
}
