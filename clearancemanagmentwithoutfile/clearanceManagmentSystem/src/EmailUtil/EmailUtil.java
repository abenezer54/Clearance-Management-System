package EmailUtil;
import javax.mail.*;
import javax.mail.internet.*;
//import javax.activation.*;
import EmailConfiguration.*;
import java.util.Properties;

public class EmailUtil {
    public static void sendEmail(String recipient, String subject, String body, String username, String password) {
        Properties properties = EmailConfiguration.getProperties();

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);
            message.setText(body);
            Transport.send(message);
            System.out.println("Email sent to " + recipient + " successfully!");
        } catch (MessagingException e) {
            System.out.println("Failed to send email: " + e.getMessage());
        }
    }
}
