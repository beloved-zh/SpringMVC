package com.zh.controller;

import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

@RestController
public class EmailController {


    /**
     * 简单邮件，没有附件和图片，纯文本
     *
     * 要发送邮件，需要获得协议和支持。开启服务POP3/SMTP服务
     *
     * 授权码：myxahpdysasdgibc
     * @return
     */
    @RequestMapping("/textEmail")
    public String textEmail(String userEmail) throws Exception {

        Properties prop = new Properties();
        prop.setProperty("mail.host","smtp.qq.com");//设置qq邮件服务器
        prop.setProperty("mail.transport.protocol","smtp");//邮件发送协议
        prop.setProperty("mail.smtp.auth","true");//需要验证用户名和密码

        //关于QQ邮箱，还要设置SSL加密，加上以下代码即可。其他邮箱不用
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable","true");
        prop.put("mail.smtp.ssl.socketFactoty",sf);

        //使用JavaMail发送邮件的5个步骤

        //1.创建定义整个应用程序所需要的环境信息的Session对象

        //QQ才有，其他邮箱不需要
        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                //发件人邮件用户名，授权码
                return new PasswordAuthentication("1425279634@qq.com","myxahpdysasdgibc");
            }
        });

        //开启Session的debug模式，可以查看程序发送Email的运行状态
        session.setDebug(true);

        //2.通过Session得到transport对象
        Transport ts = session.getTransport();

        //3.使用邮箱的用户名和授权码连接上邮件服务器
        ts.connect("smtp.qq.com","1425279634@qq.com","myxahpdysasdgibc");

        //4.创建邮件

        //注意：需要传递session
        MimeMessage message = new MimeMessage(session);

        //指明发送邮件的人
        message.setFrom(new InternetAddress("1425279634@qq.com"));

        //指明收件人
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(userEmail));

        //邮件的标题
        message.setSubject("测试程序注册验证码");

        //邮件文本内容
        message.setContent("<h1>欢迎注册***程序</h1>\n" +
                "<h2>【Beloved】您的验证码是：<span style=\"color: aqua\">6666</span>，10分钟之内有效</h2>\n" +
                "<h2 style=\"color: red\">请勿泄露，谨防被骗。如非您本人操作，请忽略</h2>","text/html;charset=UTF-8");

        //5.发送邮件
        ts.sendMessage(message,message.getAllRecipients());

        //6.关闭连接
        ts.close();

        //6.关闭连接

        return "发送成功";
    }

    @RequestMapping("/textAndImgEmail")
    public String textAndImgEmail(String userEmail) throws Exception {

        Properties prop = new Properties();
        prop.setProperty("mail.host","smtp.qq.com");//设置qq邮件服务器
        prop.setProperty("mail.transport.protocol","smtp");//邮件发送协议
        prop.setProperty("mail.smtp.auth","true");//需要验证用户名和密码

        //关于QQ邮箱，还要设置SSL加密，加上以下代码即可。其他邮箱不用
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable","true");
        prop.put("mail.smtp.ssl.socketFactoty",sf);

        //使用JavaMail发送邮件的5个步骤

        //1.创建定义整个应用程序所需要的环境信息的Session对象

        //QQ才有，其他邮箱不需要
        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                //发件人邮件用户名，授权码
                return new PasswordAuthentication("1425279634@qq.com","myxahpdysasdgibc");
            }
        });

        //开启Session的debug模式，可以查看程序发送Email的运行状态
        session.setDebug(true);

        //2.通过Session得到transport对象
        Transport ts = session.getTransport();

        //3.使用邮箱的用户名和授权码连接上邮件服务器
        ts.connect("smtp.qq.com","1425279634@qq.com","myxahpdysasdgibc");

        //4.创建邮件

        //注意：需要传递session
        MimeMessage message = new MimeMessage(session);

        //指明发送邮件的人
        message.setFrom(new InternetAddress("1425279634@qq.com"));

        //指明收件人
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(userEmail));

        //邮件的标题
        message.setSubject("测试程序注册验证码");

        //邮件文本内容
        //====================================

        //准备图片数据
        MimeBodyPart image = new MimeBodyPart();
        //图片传输需要经过数据处理
        DataHandler dh = new DataHandler(new FileDataSource("E:\\ideaProject\\SpringMVC\\spring09_mail\\src\\main\\resources\\static\\img\\1583216824.jpg"));
        image.setDataHandler(dh);//在Boby中放入处理的图片数据
        image.setContentID("a.jpg");//设置图片ID

        //准备正文数据 <img src='cid:a.jpg'/> 引入图片id
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("<h1>欢迎注册***程序</h1>\n" +
                "<h2>【Beloved】您的验证码是：<span style=\"color: aqua\">6666</span>，10分钟之内有效</h2>\n" +
                "<h2 style=\"color: red\">请勿泄露，谨防被骗。如非您本人操作，请忽略</h2>" +
                "<img src='cid:a.jpg'/>","text/html;charset=UTF-8");

        //描述数据关系
        MimeMultipart mm = new MimeMultipart();
        mm.addBodyPart(text);
        mm.addBodyPart(image);
        mm.setSubType("related");

        //设置到消息中，保存修改
        message.setContent(mm);//将编辑好的邮件放到消息中
        message.saveChanges();//保存修改

        //5.发送邮件
        ts.sendMessage(message,message.getAllRecipients());

        //6.关闭连接
        ts.close();

        //6.关闭连接

        return "发送成功";
    }

    @RequestMapping("/textAndImgAndFileEmail")
    public String textAndImgAndFileEmail(String userEmail) throws Exception {

        Properties prop = new Properties();
        prop.setProperty("mail.host","smtp.qq.com");//设置qq邮件服务器
        prop.setProperty("mail.transport.protocol","smtp");//邮件发送协议
        prop.setProperty("mail.smtp.auth","true");//需要验证用户名和密码

        //关于QQ邮箱，还要设置SSL加密，加上以下代码即可。其他邮箱不用
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable","true");
        prop.put("mail.smtp.ssl.socketFactoty",sf);

        //使用JavaMail发送邮件的5个步骤

        //1.创建定义整个应用程序所需要的环境信息的Session对象

        //QQ才有，其他邮箱不需要
        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                //发件人邮件用户名，授权码
                return new PasswordAuthentication("1425279634@qq.com","myxahpdysasdgibc");
            }
        });

        //开启Session的debug模式，可以查看程序发送Email的运行状态
        session.setDebug(true);

        //2.通过Session得到transport对象
        Transport ts = session.getTransport();

        //3.使用邮箱的用户名和授权码连接上邮件服务器
        ts.connect("smtp.qq.com","1425279634@qq.com","myxahpdysasdgibc");

        //4.创建邮件

        //注意：需要传递session
        MimeMessage message = new MimeMessage(session);

        //指明发送邮件的人
        message.setFrom(new InternetAddress("1425279634@qq.com"));

        //指明收件人
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(userEmail));

        //邮件的标题
        message.setSubject("测试程序注册验证码");

        //邮件文本内容
        //====================================

        //准备图片数据
        MimeBodyPart image = new MimeBodyPart();
        //图片传输需要经过数据处理
        DataHandler dh = new DataHandler(new FileDataSource("E:\\ideaProject\\SpringMVC\\spring09_mail\\src\\main\\resources\\static\\img\\1583216824.jpg"));
        image.setDataHandler(dh);//在Boby中放入处理的图片数据
        image.setContentID("a.jpg");//设置图片ID

        //附件
        MimeBodyPart file = new MimeBodyPart();
        file.setDataHandler(new DataHandler(new FileDataSource("E:\\ideaProject\\SpringMVC\\spring09_mail\\src\\main\\resources\\static\\stu.pdc")));
        file.setFileName("stu.pdc");//设置附件的名字

        //准备正文数据 <img src='cid:a.jpg'/> 引入图片id
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("<h1>欢迎注册***程序</h1>\n" +
                "<h2>【Beloved】您的验证码是：<span style=\"color: aqua\">6666</span>，10分钟之内有效</h2>\n" +
                "<h2 style=\"color: red\">请勿泄露，谨防被骗。如非您本人操作，请忽略</h2>" +
                "<img src='cid:a.jpg'/>","text/html;charset=UTF-8");


        //封装正文内容
        MimeMultipart mm = new MimeMultipart();
        mm.addBodyPart(text);
        mm.addBodyPart(image);
        mm.setSubType("related"); // 1.文本和图片内嵌

        //将拼装好的正文内容作为主体
        MimeBodyPart contentText = new MimeBodyPart();
        contentText.setContent(mm);

        //拼装附件
        MimeMultipart allFile = new MimeMultipart();
        allFile.addBodyPart(contentText);//正文
        allFile.addBodyPart(file);//附件
        allFile.setSubType("mixed");//正文和附件都存在在邮件中，所有类型设置为mixed


        //设置到消息中，保存修改
        message.setContent(allFile);//将编辑好的邮件放到消息中
        message.saveChanges();//保存修改

        //5.发送邮件
        ts.sendMessage(message,message.getAllRecipients());

        //6.关闭连接
        ts.close();

        //6.关闭连接

        return "发送成功";
    }
}
