package vn.jv.email;

import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;

import vn.jv.cache.CacheConstants;
import vn.jv.cache.CacheHelper;
import vn.jv.db.dao.IEmailSystemDAO;
import vn.jv.db.entity.EmailSystem;

/**
 * Mail sender used to send emails using our mail systems defined
 * in email_system table
 * 
 *
 */
public class MailSender implements IMailSender {
	protected final Logger log = LoggerFactory.getLogger(getClass());
	private CacheHelper cacheHelper = CacheHelper.getInstance();
	@Autowired@Qualifier("mailTemplateBuilder")
	private IMailTemplateBuilder mailTemplateBuilder;
	
	@Autowired@Qualifier("emailSystemDAO")
	private IEmailSystemDAO emailSystemDAO;
	
	public void send(String to, String subject, String message) {
		send(new String[] {to}, subject, message);
	}
	
	public void send(String[] to, String subject, String message) {
		JavaMailSender sender = getDefaultMailSender();
		MailSenderHelper.sendSimpleMessage(sender, to, subject, message);
	}
	
	public void send(int emailSystemId, String[] to, String subject, String message) {
		JavaMailSender sender = getMailSender(emailSystemId);
		MailSenderHelper.sendSimpleMessage(sender, to, subject, message);
	}

	
	public void send(MimeMessage mimeMessage) {
		JavaMailSender sender = getDefaultMailSender();
		sender.send(mimeMessage);
	}

	public void send(int emailSystemId, MimeMessage mimeMessage) {
		JavaMailSender sender = getMailSender(emailSystemId);
		sender.send(mimeMessage);
	}

	private JavaMailSender getMailSender(int emailSystemId) {
		String valueKey = emailSystemId + "";
		String cacheName = CacheConstants.MailUtil.GET_MAIL_SENDER_CACHE;
		JavaMailSender sender = null;
		if(cacheHelper.containsKey(cacheName, valueKey)) {
			sender = (JavaMailSender) cacheHelper.getValueFromCache(cacheName, valueKey);
		} else {
			EmailSystem emailSystem = emailSystemDAO.findById(emailSystemId);
			if(emailSystem!=null) {
				sender = MailSenderHelper.createNewSender(emailSystem);
				cacheHelper.putToCache(cacheName, valueKey, sender);
			} else {
				throw new RuntimeException("Could not find any EmailSystem with id [" + emailSystemId + "]");
			}
		}
		return sender;
	}

	private JavaMailSender getDefaultMailSender() {
		String valueKey = MailSenderHelper.DEFAULT_EMAIL_SYSTEM;
		String cacheName = CacheConstants.MailUtil.GET_MAIL_SENDER_CACHE;
		JavaMailSender sender = null;
		if(cacheHelper.containsKey(cacheName, valueKey)) {
			sender = (JavaMailSender) cacheHelper.getValueFromCache(cacheName, valueKey);
		} else {
			EmailSystem defaultEmailSystem = emailSystemDAO.getDefaultEmailSystem();
			if (defaultEmailSystem != null) {
				sender = MailSenderHelper.createNewSender(defaultEmailSystem);
				cacheHelper.putToCache(cacheName, valueKey, sender);
			} else {
				throw new RuntimeException("Could not find any default EmailSystem. Please create a new row in email_system table with IS_DEFAULT = 1");
			}
		}
		return sender;
	}
	
	/**
	 * Send email using FreeMarker to build message from a given template
	 * @param to
	 * @param subject
	 * @param templateName
	 * @param templateVars
	 */
	public void sendUsingFreeMarkerTemplate(String to, String subject, String templateName, Map<String, Object> templateVars) {
		sendUsingFreeMarkerTemplate(new String[] {to}, subject, templateName, templateVars);
	}
	
	/**
	 * Send email using FreeMarker to build message from a given template
	 * @param to
	 * @param subject
	 * @param templateName
	 * @param templateVars
	 */
	public void sendUsingFreeMarkerTemplate(String[] to, String subject, String templateName, Map<String, Object> templateVars) {
		String message = mailTemplateBuilder.buildMessageFromTemplate(templateName, templateVars);
		send(to, subject, message);
	}

	/**
	 * Send email using a given email-system and FreeMarker to build message from a given template
	 * @param to
	 * @param subject
	 * @param templateName
	 * @param templateVars
	 */
	public void sendUsingFreeMarkerTemplate(int emailSystemId, String[] to, String subject, String templateName,
			Map<String, Object> templateVars) {
		String message = mailTemplateBuilder.buildMessageFromTemplate(templateName, templateVars);
		send(emailSystemId, to, subject, message);
	}


}
