package vn.jv.cache;

/**
 * Contains all constants used for caching
 *
 */
public interface CacheConstants {
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
	public final static String FIELD_SEPARATOR = "@@";
	public final static String SAVE = "SAVE";
	public final static String SAVE_OR_UPDATE = "SAVE_OR_UPDATE";
	public final static String UPDATE = "UPDATE";
	public final static String DELETE = "DELETE" ;
	
	/**
	 * SiteGlobal cache is used for the whole site whose items are for separate purposes like:
	 */
	public interface SiteGlobal {
		public final static String SITE_GLOBAL_CACHE = "site.global.cache";
	}
	
	public interface AcRoleDAO{
		public final static String FIND_PARENT_ROLES_CACHE = "AcRoleDAO.findParentRoles.cache";
	}
	
	public interface AcPermissionDAO{
		public final static String FIND_PERMISSIONS_FOR_ROLE_CACHE = "AcPermissionDAO.findPermissionsForRole.cache";
	}
	
	public interface MailUtil {
		public final static String GET_MAIL_SENDER_CACHE = "MailUtil.getMailSender.cache";
	}
}
