package project1.ultil;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUltil {
	public static void sendMail(String smtpMS, String to, String from, String password, String subject, String body)
			throws Exception {
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", smtpMS);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.starttls.enable", "true");
		final String login = from;
		final String paswd = password;
		Authenticator auth = null;
		if (login != null && paswd != null) {
			properties.put("mail.smtp.auth", "true");
			auth = new Authenticator() {

				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(login, paswd);
				}
			};
		}
		Session session = Session.getInstance(properties, auth);
		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(from));
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));

		msg.setSubject(subject);
		msg.setContent(body, "text/html; charset=UTF-8");
		msg.setHeader("Test", "RegisterEmail");
		msg.setSentDate(new Date());
		msg.saveChanges();
		Transport.send(msg);
		System.out.println("Mail was sent");

	}

}
