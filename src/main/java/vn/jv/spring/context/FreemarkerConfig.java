package vn.jv.spring.context;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.utility.XmlEscape;

/**
 *
 * @author hunglevn@outlook.com
 *
 */
@Configuration
public class FreemarkerConfig {
	@Autowired
	private XmlEscape fmXmlEscape;
	
	@Bean
	public XmlEscape fmXmlEscape() {
		return new XmlEscape();
	}
	
	@Bean
	public FreeMarkerConfigurer freemarkerConfig() {
		/*
		<property name="templateLoaderPath" value="/WEB-INF/freemarker/"/>
        <property name="freemarkerSettings">
            <props>
                <prop key="datetime_format">MM/dd/yyyy</prop>
                <prop key="number_format">0.######</prop>
            </props>
        </property>
        <property name="freemarkerVariables">
            <map>
                <entry key="xml_escape" value-ref="fmXmlEscape"/>
            </map>
        </property>
        */
		FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
		Properties settings = new Properties();
		settings.put("datetime_format", "MM/dd/yyyy");
		settings.put("number_format", "0.######");
		freeMarkerConfigurer.setFreemarkerSettings(settings );
		
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("xml_escape", fmXmlEscape);
		freeMarkerConfigurer.setFreemarkerVariables(variables);
		
		return freeMarkerConfigurer;
	}
}
