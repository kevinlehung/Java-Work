package vn.jv.web.security;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import vn.jv.constant.WebConstants;
import vn.jv.db.entity.User;

public class JvSessionManager {
	private static JvSessionManager instance = new JvSessionManager();
	
	public static JvSessionManager getInstance() {
		return instance;
	}
	 
	protected final Logger log = LoggerFactory.getLogger(getClass());	
	
	private Map<String, HttpSession> sessionsMap;
	
	private JvSessionManager() {
		sessionsMap = new ConcurrentHashMap<String, HttpSession>();
	}

	public Map<String, HttpSession> getSessionsMap() {
		return sessionsMap;
	}

	public void setSessionsMap(Map<String, HttpSession> sessionsMap) {
		this.sessionsMap = sessionsMap;
	}
	
	public String getSessionIdByUserId(int userId) {
		HttpSession session;
		User user;
		String sessionId = null;
		Iterator<Map.Entry<String, HttpSession>> it = sessionsMap.entrySet().iterator();
	    while (it.hasNext()) {
	    	Map.Entry<String, HttpSession> entry = (Map.Entry<String, HttpSession>)it.next();
	    	session = entry.getValue();
			try {
				user = (User) session.getAttribute(WebConstants.SessionParams.LOGINED_USER);
				if (user != null && user.getUserId() == userId) {
					sessionId = session.getId();
					break;
				}
			} catch (IllegalStateException ise) {
				log.info("Session of userId#" + userId + " already invalidated.");
			}	
	    }
		return sessionId;
	}
	
	public void releaseOldSession(int userId) {
		try {
			String oldSessionId = this.getSessionIdByUserId(userId);
			if (oldSessionId != null) {
				HttpSession oldSession = sessionsMap.get(oldSessionId);
				oldSession.invalidate();
			}
		} catch (Exception e) {
			log.error("Error while release old session of userId#" + userId + " ", e);
		}		
	}
}
