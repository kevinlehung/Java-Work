package vn.jv.constant;

import java.util.HashMap;
import java.util.Map;


public interface WebConstants {
	public static final String BUILD_NUMBER = "buildNumber";
	public static final String JSESSIONID = ";jsessionid=";
	public static final String USER_ID = "userId";
    public static final String SUPER_ADMIN = "Super Admin";
    public static final String PAGE_SUFFIX = ".jv";   
    public static final String LAST_LOGIN = "lastLogin";
    public static final String DATE_FORMAT = "MM/dd/yyyy h:mm a";
    public static final String NOT_AVAILABLE = "N/A";
    
	public interface SessionParams {
    	public static final String LOGINED_USER = "logined.user";
    	public static final String LOGINED_AUTHENTICATION = "logined.authentication";
    	public static final String LOGINED_USER_ROLES = "logined.user.roles";
    	public static final String REQUEST_HISTORIES = "REQUEST_HISTORIES";
    }
	
	public interface FixValue {
    	public static final int PASSWORD_HASH_VALID = 0;
    	public static final int PASSWORD_HASH_NOT_EXIST = 1;
    	public static final int PASSWORD_HASH_EXPIRED = 2;
    	public static final int PASSWORD_HASH_INVALID = 3;
    	public static final int PASSWORD_USED_ALREADY = 4;
    	public static final int PASSWORD_HASH_DAYS_TO_EXPIRE = 1;
    	public static final int PASSWORD_HASH_LENGTH = 32;
    	
    	public static final String DEFAULT_DATE_FORMAT = "MM/dd/yyyy";
    }
	
	public interface Params {
		public static final String TIME_ZONE = "timeZone";
    }
    
	public static final Map<String, String> TIME_ZONES = new HashMap<String, String>() {
		{
			put("-12:00,0", "International Date Line Wes");
			put("-11:00,0", "Midway Island");
			put("-10:00,0", "Hawaii");
			put("-09:00,1", "Alaska");
			put("-08:00,1", "Pacific Time");
			put("-07:00,0", "Arizona");
			put("-07:00,1", "Mountain Time");
			put("-06:00,0", "Central America");
			put("-06:00,1", "Central Time");
			put("-05:00,0", "Indiana");
			put("-05:00,1", "Eastern");
			put("-04:00,1", "Atlantic");
			put("-04:00,0", "Caracas");
			put("-03:30,1", "Newfoundland");
			put("-03:00,1", "Greenland");
			put("-03:00,0", "Buenos Aires");
			put("-02:00,1", "Mid-Atlantic");
			put("-01:00,1", "Azores");
			put("-01:00,0", "Cape Verde Is.");
			put("00:00,1", "GMT: Dublin");
			put("+01:00,1", "Amsterdam");
			put("+01:00,0", "West Central Africa");
			put("+02:00,1", "Amman");
			put("+02:00,0", "Harare");
			put("+03:00,1", "Baghdad");
			put("+03:00,0", "Kuwait");
			put("+03:30,0", "Tehran");
			put("+04:00,0", "Abu Dhadi");
			put("+04:00,1", "Baku");
			put("+04:30,0", "Kabul");
			put("+05:00,1", "Ekaterinburg");
			put("+05:00,0", "Islamabad");
			put("+05:30,0", "Chennai");
			put("+05:45,0", "Kathmandu");
			put("+06:00,0", "Astana");
			put("+06:00,1", "Almaty");
			put("+06:30,0", "Rangoon");
			put("+07:00,1", "Krasnoyarsk");
			put("+07:00,0", "Bangkok");
			put("+08:00,0", "Beijing");
			put("+08:00,1", "Irkutsk");
			put("+09:00,1", "Yakutsk");
			put("+09:00,0", "Seoul");
			put("+09:30,0", "Darwin");
			put("+09:30,1", "Adelaide");
			put("+10:00,0", "Brisbane");
			put("+10:00,1", "Canberra");
			put("+11:00,0", "Magadan");
			put("+12:00,1", "Auckland");
			put("+12:00,0", "Fiji");
			put("+13:00,0", "Nuku'alofa");
		}
	};
	
    public interface Views {
        public static final String PAGE_NOT_FOUND = "pageNotFound";
        public static final String ERROR = "error";
        
        public static final String SIGN_IN = "security/sign_in";
        public static final String SIGN_UP = "security/sign_up";
        public static final String SIGN_UP_SUCCESS = "security/sign_up_success";
        public static final String SESSION_EXPIRED = "security/sessionExpired";
        public static final String FORGOT_PASSWORD = "security/forgot_password";
        public static final String PASSWORD_IS_SENT = "security/password_is_sent";
        
        public static final String POST_JOB = "post_job";
        public static final String POST_JOB_PREVIEW = "post_job_preview";
        public static final String POST_JOB_DONE = "post_job_done";
        public static final String JOBS_LIST = "jobs_list";
        public static final String JOB_DETAIL = "job_detail";
        public static final String SKILL_SET = "skill_set";
        
        public static final String USER_PROFILE_OVERVIEW = "user_profile_overview";
        public static final String USER_JOBS_HISTORY = "user_jobs_history";
        public static final String USER_SKILLS = "user_skills";
        
        public static final String SKILL_TEST = "skill_test";
        public static final String SKILL_TEST_PRACTICE = "skill_test_practice";
        public static final String SKILL_TEST_PRACTICE_COMPLETE = "skill_test_practice_complete";
        public static final String SKILL_TEST_PRACTICE_OUT_OF_TIME = "skill_test_practice_out_of_time";
        
        public static final String SKILL_TEST_QUESTION = "skill_test_question";
        public static final String SKILL_TEST_QUESTION_COMPLETE = "skill_test_question_complete";
        public static final String SKILL_TEST_QUESTION_TIMEOUT = "skill_test_question_timeout";
        
        public static final String RESET_PASSWORD = "security/resetPassword";
        public static final String ACCESS_DENIED = "security/AccessDenied";
    }
    
    public interface Pages {
        public static final String JOBS_LIST = "jobs/%s/list." + PAGE_SUFFIX;
        
    }
    
}
