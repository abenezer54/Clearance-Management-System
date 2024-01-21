package EmailSending;
import EmailUtil.*;

public class EmailSending {
    public static void emailsend(String recipient, String Subject, String Body) {
        String recipientEmail = recipient;
        String subject = Subject;
        String body = Body;

        String username = "abigailfh19@gmail.com"; // Replace with your email address
        String password = "aigb qyyi weyv mdbz"; // Replace with your email password

        EmailUtil.sendEmail(recipientEmail, subject, body, username, password);
    }
}
