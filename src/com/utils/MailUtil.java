package com.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 未完成....................................
 * <p>Title: Module Information         </p>
 * <p>Description: Function Description </p>
 * <p>Copyright: Copyright (c) 2016     </p>
 * <p>Company: ND Co., Ltd.       </p>
 * <p>Create Time: 2016年10月12日           </p>
 * @author Administrator
 * <p>Update Time:                      </p>
 * <p>Updater:                          </p>
 * <p>Update Comments:                  </p>
 */
public class MailUtil {
    public static void postMail(String[] recipients, String subject,String message,String from) throws MessagingException{
        boolean debug = false;
        
        final String userName="1731805893@qq.com";
        final String password = "19921023bbb";
        //设置host smtp地址
        Properties props= new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.qq.com");
        props.put("mail.sender.username", userName);
        props.put("mail.sender.password", password);
        
        Authenticator authenticator = new Authenticator() {
           @Override
        protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
            // TODO Auto-generated method stub
            return new javax.mail.PasswordAuthentication(userName, password);
        }
        };
        
        //create some properties and get the default Session 
        Session session = Session.getDefaultInstance(props,authenticator);
        session.setDebug(debug);
        
        //创建消息
        Message msg = new MimeMessage(session);
        
     // set the from and to address  
        InternetAddress addressFrom = new InternetAddress(from);  
        msg.setFrom(addressFrom);  
        
        InternetAddress[] addressTo = new InternetAddress[recipients.length];  
        for (int i = 0; i < recipients.length; i++)  
        {  
            addressTo[i] = new InternetAddress(recipients[i]);  
        }  
        msg.setRecipients(Message.RecipientType.TO, addressTo);  

        // Optional : You can also set your custom headers in the Email if you Want  
        msg.addHeader("MyHeaderName", "myHeaderValue");  

        // Setting the Subject and Content Type  
        msg.setSubject(subject);  
        msg.setContent(message, "text/plain");  
        Transport transport = session.getTransport("smtp");
        transport.connect("smtp.qq.com", userName, password);
        transport.send(msg,msg.getAllRecipients());  
    }
    
  public static void main(String[] args) throws MessagingException {
      String[] recipients ={"2642556850@qq.com"};
      String subject ="test";
      String message =" hello wolrd";
      String from ="1731805893@qq.com";
      MailUtil.postMail(recipients, subject, message, from);
}
}
