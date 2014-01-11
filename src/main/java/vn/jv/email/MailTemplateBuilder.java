package vn.jv.email;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Component
public class MailTemplateBuilder implements IMailTemplateBuilder {
	private static final Map<String, Object> COMMON_VARS;
	static {
		COMMON_VARS = new HashMap<String, Object>();
		COMMON_VARS.put("ADMIN_SIGNATURE", "Administrator");
	}
	@Autowired@Qualifier("freemarkerConfig")
	private Configuration configuration;
	
	
	/**
	 * Build message from FreeMarker template
	 * @param templateName
	 * @param templateVars
	 * @return
	 */
	public String buildMessageFromTemplate(String templateName, Map<String, Object> templateVars) {
		try {
			Template template = configuration.getTemplate(templateName);
			if(templateVars!=null) {
				templateVars.putAll(COMMON_VARS);
			} else {
				templateVars = COMMON_VARS;
			}
			String message = FreeMarkerTemplateUtils.processTemplateIntoString(template, templateVars);
			return message;
		} catch (Exception e) {
			throw new RuntimeException("Failed to build content from template [" + templateName + "]", e);
		}
	}	

}
