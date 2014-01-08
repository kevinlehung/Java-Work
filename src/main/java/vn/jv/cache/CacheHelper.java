package vn.jv.cache;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.stat.SecondLevelCacheStatistics;
import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import vn.jv.util.Lib;

/**
 * @Description: This class contains helper methods to Ehcache CacheManager.
 * @version 1.0
 */
public class CacheHelper implements InitializingBean{
	public static final String CACHE_CFG_FILE = "jw-ehcache.xml";
	private static final String CACHE_REQUEST = "siteCache";
	private static final String GET_CACHE_INFO = "getInfo";
	private static final String CLEAR_CACHE = "clearCache";
	private static final String DISABLE_CACHE = "disableCache";
	private static final String ENABLE_CACHE = "enableCache";
	private static final String ACTION = "action";
	private static final String CACHE_NAME = "cacheName";
	public static final String ALL_CACHES = "*";
	
	protected final Log logger = LogFactory.getLog(getClass());
	protected CacheManager cacheManager = null;
	/**
	 * To disable cache-support, call CacheHelper.getInstance().disableCache(true);
	 * Default is enable cache-support
	 */
	protected boolean disableCache = false;

	private static CacheHelper instance = null;
	public static CacheHelper getInstance() {
		if(instance == null) {
			instance = new CacheHelper();
		}
		return instance;
	}
	
	/**
	 * The following constructor is used to load cache config file directly 
	 * to create a cacheManager instance.
	 * If we intend to load it using Spring context loader in web.xml, we should delete
	 * this constructor
	 */
	private CacheHelper () {
		loadCacheDirectlyFromFile();
	}
	
	private void loadCacheDirectlyFromFile() {
		URL url = getClass().getResource(CACHE_CFG_FILE);
		if(url==null) {
			throw new RuntimeException("Could not find cache config file " + CACHE_CFG_FILE);
		}
		cacheManager = CacheManager.create(url);
	}
	
	public CacheManager getCacheManager() {
		return cacheManager;
	}

	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}
	
	public boolean isDisableCache() {
		return disableCache;
	}

	public void disableCache(boolean disableCache) {
		this.disableCache = disableCache;
	}

	protected Cache getCache(String cacheName){
		debugCacheManager(cacheManager);
		
		Cache cache = cacheManager.getCache(cacheName);
		if (cache == null) {
			throw new RuntimeException("Could not find any cache with name '" + cacheName + "'.");
		}
		return cache;
	}
	
	public Object getValueFromCache(String cacheName, String valueKey){
		Object result = null;
		long start = System.currentTimeMillis();
		Cache cache = getCache(cacheName);
		if (cache.isKeyInCache(valueKey)) {
			Element cacheElement = cache.get(valueKey);
			if(cacheElement==null){
				String errMsg = "Null cache element found for [" + cacheName + "=>" + valueKey + "]";
				System.err.println(errMsg);
				logger.error(errMsg);
				return null;
			}
			result = cacheElement.getValue();
		}
		return result;
	}
	
	public boolean containsKey(String cacheName, String valueKey){
		if(disableCache == true) {
			return false;
		}
		Cache cache = getCache(cacheName);
		return cache.isKeyInCache(valueKey);
	}

	@SuppressWarnings("unchecked")
	protected List<Object> getValuesFromCache(String cacheName) {
		List<Object> result = null;
		long start = System.currentTimeMillis();
		Cache cache = getCache(cacheName);
		Object cacheValue = null;

		List<String> keysList = cache.getKeys();
		if (keysList != null && ! keysList.isEmpty()) {
			result = new ArrayList<Object>();
			Element cacheElement = null;

			for (String valueKey : keysList) {
				cacheElement = cache.get(valueKey);
				if(cacheElement==null){
					String errMsg = "Null cache element found for [" + cacheName + "=>" + valueKey + "]";
					System.err.println(errMsg);
					logger.error(errMsg);
					return null;
				}
				cacheValue = cacheElement.getValue();
				result.add(cacheValue);
			}
		}
		return result;
	}

	public void putToCache(String cacheName, String valueKey, Object value){
		if(disableCache == true) {
			return;
		}
		Element newCacheElement = new Element(valueKey, (Serializable) value);
		Cache cache = getCache(cacheName);
		cache.put(newCacheElement);
	}
	
	public boolean removeFromCache(String cacheName, String valueKey){
		boolean removedOK = false;
		Cache cache = getCache(cacheName);
		if (cache.isKeyInCache(valueKey)) {
			removedOK = cache.remove(valueKey);
		}
		return removedOK;
	}
	
	public static String buildUniqueKey(String [] fields) {
		StringBuffer buffer = new StringBuffer();
		for (int i=0; i<fields.length; i++){
			if(i>0){
				buffer.append(CacheConstants.FIELD_SEPARATOR);
			}
			buffer.append(fields[i]);
		}
		return buffer.toString();
	}

	public void afterPropertiesSet() throws Exception {
		Assert.notNull(cacheManager, "cacheManager can not be null.");		
	}
	
	public static void debugSecondLevelCache(Session session){
		
		Statistics statistics = session.getSessionFactory().getStatistics();
		String[] cacheNames = statistics.getSecondLevelCacheRegionNames();
		for(int i=0; i<cacheNames.length; i++){
			SecondLevelCacheStatistics cacheStatistics = statistics.getSecondLevelCacheStatistics(cacheNames[i]);
			try {
				Map map = cacheStatistics.getEntries();
				for(Iterator<Map.Entry> ite = map.entrySet().iterator(); ite.hasNext(); ){
					Map.Entry entry = ite.next();
					System.out.println("Cached found for " + entry.getKey() + "=[" + entry.getValue()+ "]");
				}
			} catch (Exception e) {}
		}		
	}	
	
	public static void debugCacheManager(CacheManager cacheManager){
		String[] cacheNames = cacheManager.getCacheNames();
		for(int i=0; i<cacheNames.length; i++){
			Cache cache = cacheManager.getCache(cacheNames[i]);
			List keys = cache.getKeys();
			for(int j=0; j<keys.size(); j++){
				Object valueKey = keys.get(j);
				Element cacheElement = cache.get(valueKey);
				if(cacheElement!=null){
					Object result = cacheElement.getValue();
					System.out.println("Cached data found for [" + cacheNames[i] + "=>" + valueKey + "=" + result + "].");
				}
			}
		}
	}

	public static boolean isCacheRequest(HttpServletRequest request){
		boolean isCacheRequest = false;
		String requestUri = request.getRequestURI();
		if(requestUri!=null && requestUri.endsWith(CACHE_REQUEST)){
			isCacheRequest = true;
		}
		return isCacheRequest;
	}
	

	public static void performCacheRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String result = "";
		try {
			CacheManager cacheManager = CacheHelper.getInstance().getCacheManager();
			String action = request.getParameter(ACTION);
			String cacheName = request.getParameter(CACHE_NAME);
			if(CLEAR_CACHE.equalsIgnoreCase(action)){
				result = CacheHelper.clearCache(cacheManager, cacheName);
			} else if(GET_CACHE_INFO.equalsIgnoreCase(action)){
				result = CacheHelper.getCacheInfo(cacheManager, cacheName);
			} else if(ENABLE_CACHE.equalsIgnoreCase(action)){
				CacheHelper.getInstance().disableCache(false);
				result = "Enable cache-support: " + (!CacheHelper.getInstance().isDisableCache());
			}  else if(DISABLE_CACHE.equalsIgnoreCase(action)){
				CacheHelper.getInstance().disableCache(true);
				/**
				 * Clear all caches to avoid getting value from cache by chance
				 */
				result = CacheHelper.clearCache(cacheManager, ALL_CACHES);
				result = result + Lib.LINE_SEPARATOR + "Disable cache-support: " + CacheHelper.getInstance().isDisableCache();
			} else {
				result = "Missing or invalid action parameter: " + action;
			}
		} catch (Exception e) {
			result = "Error when performing " + CACHE_REQUEST + " request: " + Lib.getStackTrace(e);
		}
		response.getOutputStream().write(result.getBytes());
	}

	public static String clearCache(CacheManager cacheManager, String cacheName) {
		StringBuffer buffer = new StringBuffer();
		if(ALL_CACHES.equals(cacheName)){
			String[] cacheNames = cacheManager.getCacheNames();
			for(int i=0; i<cacheNames.length; i++){
				cacheName = cacheNames[i];
				Cache cache = cacheManager.getCache(cacheName);
				int noOfItems = cache.getSize();
				cache.removeAll();
				buffer.append(CacheConstants.LINE_SEPARATOR + "Cleared cache \"" + cacheName + "\" successfully [" + noOfItems + "].");
			}
		} else {
			Cache cache = cacheManager.getCache(cacheName);
			if(cache==null){
				return "Cache \"" + cacheName + "\" not found.";
			}
			int noOfItems = cache.getSize();
			cache.removeAll();
			buffer.append(CacheConstants.LINE_SEPARATOR + "Cleared cache \"" + cacheName + "\" successfully [" + noOfItems + "].");
		}
		
		return buffer.toString();
	}
	
	public static String getCacheInfo(CacheManager cacheManager, String cacheName) {
		StringBuffer buffer = new StringBuffer();
		if(ALL_CACHES.equals(cacheName)){
			String[] cacheNames = cacheManager.getCacheNames();
			for(int i=0; i<cacheNames.length; i++){
				cacheName = cacheNames[i];
				Cache cache = cacheManager.getCache(cacheName);
				int noOfItems = cache.getSize();
				buffer.append(CacheConstants.LINE_SEPARATOR + "Cache \"" + cacheName + "\": [Total items = " + noOfItems + "].");
			}
		} else {
			Cache cache = cacheManager.getCache(cacheName);
			if(cache==null){
				return "Cache \"" + cacheName + "\" not found.";
			}
			int noOfItems = cache.getSize();
			buffer.append(CacheConstants.LINE_SEPARATOR + "Cache \"" + cacheName + "\": [Total items = " + noOfItems + "].");
		}
		
		return buffer.toString();
	}
	
}
