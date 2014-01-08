package vn.jv.email;

import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.util.StringUtils;

import vn.jv.db.entity.EmailSystem;
import vn.jv.util.Lib;

public class MailSenderHelper {
	static final String DEFAULT_EMAIL_SYSTEM = "DEFAULT_EMAIL_SYSTEM";
	static final int SMTP_NON_SSL_PORT = 25;

	static void sendSimpleMessage(JavaMailSender sender, String[] to, String subject, String message) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(to);
		mailMessage.setSubject(subject);
		mailMessage.setText(message);
		sender.send(mailMessage);
	}

	static JavaMailSender createNewSender(EmailSystem emailSystem) {
		try {
			JavaMailSenderImpl sender = new JavaMailSenderImpl();
			sender.setHost(emailSystem.getHost());
			sender.setPort(emailSystem.getPort());
			sender.setUsername(emailSystem.getUserName());
			sender.setPassword(emailSystem.getPassword());
			Properties javaMailProperties = new Properties();
			javaMailProperties.put("mail.debug", "true");
			javaMailProperties.setProperty("mail.transport.protocol", emailSystem.getProtocol());			
			javaMailProperties.setProperty("mail.smtp.auth", "true");
			
			if (StringUtils.hasText(emailSystem.getSenderEmail())) {
				javaMailProperties.setProperty("mail.smtp.from", emailSystem.getSenderEmail());
			}
			/*
			 * Fix org.springframework.mail.MailSendException: 
			 * Mail server connection failed; nested exception is javax.mail.MessagingException: 
			 * Can't send command to SMTP host;
			 */			
			if (emailSystem.getPort() == SMTP_NON_SSL_PORT) {
				javaMailProperties.setProperty("mail.smtp.ssl.enable", "false");
				javaMailProperties.setProperty("mail.smtp.starttls.enable", "false");
			} else {
				javaMailProperties.setProperty("mail.smtp.starttls.enable", "true");
			}
			sender.setJavaMailProperties(javaMailProperties);
			return sender;
		} catch (Exception e) {
			throw new RuntimeException("Failed to create sender to [" + Lib.convertToString(emailSystem) + "]", e);
		}
	}

}
