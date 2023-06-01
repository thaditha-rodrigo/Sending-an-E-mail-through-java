
package Models;

import java.util.List;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailSender 
{
    private Session session;

    
    private void init() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        session = Session.getInstance(props, new Authenticator() 
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication ("timeticker86@gmail.com","hdvgwkkanonutxix") ;//users gmail and passowrd of the users 
            }
            
        }
        );
    }

    public void sendEmail(String result) throws MessagingException {
         System.out.println("Preparing to send mail.");
         init();
         Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress("timeticker86@gmail.com"));//users email address
         message.setRecipients(Message.RecipientType.TO,
             InternetAddress.parse(result));
         message.setSubject("Item Out of Stcok Notice");
         message.setText("Item is out of stock.\nPlease contact Mrs.Sudharma - 077693454");
         Transport.send(message);
         System.out.println("Message sent successfully.");
    }
 
}
    
