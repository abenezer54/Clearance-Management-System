import EmailUtil.*;
public class testemail {
    public static void main(String[] args) {
        String recipientEmail = "bigidovi@gmail.com";
        String subject = "Test Email";
        String body = "This is a test email.";

        String username = "abigailfh19@gmail.com"; // Replace with your email address
        String password = "aigb qyyi weyv mdbz"; // Replace with your email password

        EmailUtil.sendEmail(recipientEmail, subject, body, username, password);
    }
}

