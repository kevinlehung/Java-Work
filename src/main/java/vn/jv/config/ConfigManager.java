package vn.jv.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;

/**
 * 
 *
 */
public class ConfigManager {
	private static final String CONFIG_FILE = "config.properties";
	private static String CONFIG_OVERRIDE_FILE_NAME = "config_override.properties";
	
	private Properties properties = new Properties();
	
	private static ConfigManager instance = new ConfigManager();
	public static ConfigManager getInstance() {
		return instance;
	}
	
	private ConfigManager() {
		InputStream inStream = null;
		String cfgFile = CONFIG_FILE;
		try {
			inStream = ConfigManager.class.getResourceAsStream(cfgFile);
			if(inStream == null) {
				throw new RuntimeException("Could not find file '" + cfgFile + "' in classpath");
			}
			properties.load(inStream);
			inStream.close();
			cfgFile = CONFIG_OVERRIDE_FILE_NAME;
			inStream = ConfigManager.class.getResourceAsStream(cfgFile);
			if(inStream == null) {
				throw new RuntimeException("Could not find file '" + cfgFile + "' in classpath");
			}
			Properties overrideProperties = new Properties();
			overrideProperties.load(inStream);
			properties.putAll(overrideProperties);
		} catch (IOException e) {
			throw new RuntimeException("Failed to load config data from file '" + cfgFile + "'", e);
		} finally {
			IOUtils.closeQuietly(inStream);
		}
	}
	
	public String getProperty(String propertyName) {
		return properties.getProperty(propertyName);
	}
	
	public int getIntProperty(String propertyName) {
		String value = properties.getProperty(propertyName);
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new RuntimeException("Invalid value found for property '" + propertyName + "'", e);
		}
	}
	
	public boolean getBoolProperty(String propertyName) {
		String value = properties.getProperty(propertyName);
		try {
			return Boolean.parseBoolean(value.trim());
		} catch (NumberFormatException e) {
			throw new RuntimeException("Invalid value found for property '" + propertyName + "'", e);
		}
	}
	
	public void setProperty(String propertyName, String value) {
		properties.setProperty(propertyName, value);
	}
	
	public Properties getProperties() {
		return properties;
	}
	
	public static String getBuildVersion () {
	    String buildNo = ConfigManager.getInstance().getProperty("build.no");
	    if(buildNo!=null && buildNo.trim().length()>0){
	    	buildNo = " - Build no " + buildNo;
	    } else {
	    	buildNo = "";
	    }
		return buildNo;
	}
	
	public static void main(String[] args) {
		boolean is = getInstance().getBoolProperty("force.image.prefetch.off");
		is = false;
	}
	
}
