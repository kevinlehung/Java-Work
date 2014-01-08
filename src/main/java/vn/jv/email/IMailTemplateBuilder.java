package vn.jv.email;

import java.util.Map;

public interface IMailTemplateBuilder {
	public String buildMessageFromTemplate(String templateName, Map<String, Object> templateVars);
}
