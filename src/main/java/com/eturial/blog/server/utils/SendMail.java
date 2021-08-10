package com.eturial.blog.server.utils;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class SendMail {
    public static int sendMail(String mailBox) {
        try {

            System.out.println("sendMail : " + mailBox);
            //创建一个配置文件并保存
            Properties properties = new Properties();
            properties.setProperty("mail.host","smtp.qq.com");
            properties.setProperty("mail.transport.protocol","smtp");
            properties.setProperty("mail.smtp.auth","true");

            //QQ存在一个特性设置SSL加密
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.ssl.socketFactory", sf);

            //创建一个session对象
            Session session = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("1220405381@qq.com","13753309889yh");
                }
            });

            //开启debug模式
            session.setDebug(true);

            //获取连接对象
            Transport transport = session.getTransport();

            //连接服务器
            transport.connect("smtp.qq.com","2563609671@qq.com","13753309889yh");

            //创建邮件对象
            MimeMessage mimeMessage = new MimeMessage(session);

            //邮件发送人
            mimeMessage.setFrom(new InternetAddress("1220405381@qq.com"));

            mailBox = URLDecoder.decode(mailBox,"utf-8");

            //邮件接收人
            mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress(mailBox));

            //邮件标题
            mimeMessage.setSubject("欢迎注册Eturial's blog");

            int random = (int)((Math.random()) * 1000000);
            //邮件内容
            mimeMessage.setContent("验证码：" + random ,"text/html;charset=UTF-8");

            //发送邮件
            transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients());

            //关闭连接
            transport.close();
            return random;
        } catch (MessagingException | GeneralSecurityException | UnsupportedEncodingException exception1){
            exception1.printStackTrace();
            return  -1;
        }

    }
}
