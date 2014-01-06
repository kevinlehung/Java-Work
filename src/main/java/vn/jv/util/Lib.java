package vn.jv.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Max
 *
 */
public class Lib {
	protected static final Logger log = LoggerFactory.getLogger(Lib.class);
	
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
	public static final String LOG_PART_SEPARATOR = "===================================================================";
	public static final String LOG_LINE_SEPARATOR = "----------------------------------------------------------";
	
	/**
	 * This method is used to get stack info like log4j
	 * @param e
	 * @return
	 */
	public static String getStackTrace(Throwable e){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString();
	}
	
	public static String getAllMessages(Throwable e){
        String message = e.getMessage();
        Throwable cause = e.getCause();
        if(cause!=null) {
        	return message + " -> " + getAllMessages(cause);
        }
        return message;
	}
	
	public static Map<String, Object> buildParamsMap(String name, Object value){
		return buildParamsMap(new String[] {name}, new Object[] {value});
	}
	
	/**
	 * Helper method used in DAO to build params map
	 * @param names
	 * @param values
	 * @return
	 */
	public static Map<String, Object> buildParamsMap(String[] names, Object[] values){
		if(names==null || names.length==0 || values==null) {
			return Collections.EMPTY_MAP;
		}
		if(names.length != values.length) {
			throw new RuntimeException("Names and values must have the same size");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		for (int i = 0; i < names.length; i++) {
			map.put(names[i], values[i]);
		}
		return map;
	}
	
}
