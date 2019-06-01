package cn.ishangit.shop.commons.constant;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description:邮件发送工具类
 * @author: Chen
 * @create: 2019-06-01 15:22
 **/
public class SendEmailUtils {
    @Autowired
    private Email simpleEmail;
    /**
     * 发送邮件
     * @param subject 邮件主题
     * @param msg 邮件内容
     * @param addTo 收件人
     * @throws EmailException
     */
    public void sendEmail(String subject,String msg,String addTo) throws EmailException {
        //邮件主题
        simpleEmail.setSubject(subject);
        //邮件内容
        simpleEmail.setMsg(msg);
        //收件人
        simpleEmail.addTo(addTo);
        //发送
        simpleEmail.send();
    }
}
