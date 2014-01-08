package vn.jv.web.security;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.navigator.menu.MenuComponent;
import net.sf.navigator.menu.MenuRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import vn.jv.constant.WebConstants;
import vn.jv.db.dao.IAcRoleDAO;
import vn.jv.db.dao.IMenuItemDAO;
import vn.jv.db.dao.IUserDAO;
import vn.jv.db.dao.IUserLoginDAO;
import vn.jv.db.entity.AcRole;
import vn.jv.db.entity.MenuItem;
import vn.jv.db.entity.UserLogin;
import vn.jv.service.ISecurityService;

/**
 * Customization to handle webservices success login
 * 
 * 
 * 
 */
public class JvSuccessLoginHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired@Qualifier("securityService")
	private ISecurityService securityService;

	@Autowired
	@Qualifier("userDAO")
	private IUserDAO userDAO;

	@Autowired
	@Qualifier("acRoleDAO")
	private IAcRoleDAO acRoleDAO;
	
	@Autowired
	@Qualifier("userLoginDAO")
	private IUserLoginDAO userLoginDAO;
	
	@Autowired
	@Qualifier("menuItemDAO")
	private IMenuItemDAO menuItemDAO;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		try {
			vn.jv.db.entity.User user = userDAO.findByEmail(authentication.getName());
			/**
			 * Be used for showing last login link
			 */
			String lastLoginTime = getLastSuccessLoginTime(user.getUserId());
			request.getSession().setAttribute(WebConstants.LAST_LOGIN, lastLoginTime != null ? lastLoginTime : "");
			
			user = auditSuccessLogin(request, user);
			SecurityHelper.handlePasswordExpired(userDAO, user);
			/**
			 * Put this logined user and authentication to the session so we can get them later if needed
			 */
			SecurityHelper.saveLoginedUserToSession(request, user);
			SecurityHelper.saveLoginedAuthenticationToSession(request, authentication);
			/**
			 * Query and put his/her roles to the session so we can get it later if needed
			 */
			List<AcRole> roles = acRoleDAO.findAllRoles(user.getUserId());
			SecurityHelper.saveLoginedUserRolesToSession(request, roles);
			
			JvSessionManager.getInstance().releaseOldSession(user.getUserId());
			HttpSession session = request.getSession();
			JvSessionManager.getInstance().getSessionsMap().put(session.getId(), session);
			
			/**
			 * After user logged into server successfully, the MenuRepository will be built and stored to session to
			 * render menus of this user
			 */
			MenuRepository repository = buildMenuRepository(request);
			request.getSession().setAttribute("repository", repository);
			
			/**
			 * Normal web login, delegate processing to super class
			 */
			super.onAuthenticationSuccess(request, response, authentication);
		} catch (Exception e) {
			throw new RuntimeException("Unexpected error when logging in user [" + authentication.getName() + "]", e);
		}
	}
	
	private String getLastSuccessLoginTime(Integer userId) {
		UserLogin userLogin = userLoginDAO.findLastSuccessLogin(userId);
		if (userLogin == null) {
			return null;
		}
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(WebConstants.DATE_FORMAT);
		String result = simpleDateFormat.format(userLogin.getLoginTime());
		result += " " + userLogin.getTimeZone();
		return result;
	}

	/**
	 * Update login info so we can track later
	 * @param request 
	 * @param userEmail
	 * @return
	 */
	private vn.jv.db.entity.User auditSuccessLogin(HttpServletRequest request, vn.jv.db.entity.User user) {
		Timestamp now = new Timestamp(System.currentTimeMillis());
		/**
		 * Check if PASSWORD_LAST_CHANGED_DATE = null, we set it now
		 */
		if(user.getPasswordLastChangedDate()==null) {
			user.setPasswordLastChangedDate(now);
		}
		user.setLastLoginDate(now);
		userDAO.update(user);
		
		String timeZone = SecurityHelper.getTimezone(request);
		userLoginDAO.auditNewLogin(request.getRemoteAddr(), user, now, UserLogin.LOGIN_SUCCESS, timeZone);
		return user;
	}


	private MenuRepository buildMenuRepository(HttpServletRequest request) {
		MenuRepository repository = new MenuRepository();
		MenuRepository defaultRepository = (MenuRepository) request.getSession().getServletContext()
				.getAttribute(MenuRepository.MENU_REPOSITORY_KEY);
		repository.setDisplayers(defaultRepository.getDisplayers());
		List<AcRole> loginedUserRoles = SecurityHelper.getLoginedUserRoles(request);
		
		boolean hasLogout = false;
		List<MenuItem> menuItems = findMenuItemsOfUser(loginedUserRoles);
		for (MenuItem menuItem : menuItems) {
			MenuComponent menuComponent = new MenuComponent();
			populateMenuComponent(request, menuItem, menuComponent);
			
			if (!hasLogout && MenuItem.LOGOUT_MENU_NAME.equals(menuItem.getName())) {
				hasLogout = true;
			}
			
			MenuItem parentMenuItem = menuItem.getParentMenuItem();
			if (parentMenuItem != null) {
				MenuComponent parentMenu = repository.getMenu(parentMenuItem.getName());
				if (parentMenu == null) {
					parentMenu = new MenuComponent();
					populateMenuComponent(request, parentMenuItem, parentMenu);
					repository.addMenu(parentMenu);
				}
				
				menuComponent.setParent(parentMenu);
			}
			
			repository.addMenu(menuComponent);
		}
		
		if (!hasLogout) {
			MenuItem logoutMenuItem = menuItemDAO.findByName(MenuItem.LOGOUT_MENU_NAME);
			if (logoutMenuItem != null) {
				MenuComponent menuComponent = new MenuComponent();
				populateMenuComponent(request, logoutMenuItem, menuComponent);
				repository.addMenu(menuComponent);
			}
		}
		
		return repository;
	}

	private List<MenuItem> findMenuItemsOfUser(List<AcRole> loginedUserRoles) {
		List<MenuItem> menuItems = null;
		if (isSuperAdmin(loginedUserRoles)) {
			menuItems = menuItemDAO.findAllWithOrder();
		} else {
			menuItems = securityService.findMenuItemsByRoles(loginedUserRoles);
		}
		return menuItems;
	}
	
	private boolean isSuperAdmin(List<AcRole> acRoles) {
		for (AcRole acRole : acRoles) {
			if (WebConstants.SUPER_ADMIN.equals(acRole.getRoleName())) {
				return true;
			}
		}
		
		return false;
	}

	private void populateMenuComponent(HttpServletRequest request, MenuItem menuItem,
			MenuComponent menuComponent) {
		menuComponent.setName(menuItem.getName());
		menuComponent.setTitle(menuItem.getTitle());
		String location = menuItem.getLocation();
		if (!location.startsWith("javascript:;")) {
			location = request.getContextPath() + "/" + location;
		}
		menuComponent.setLocation(location);
		
		if (menuItem.getImage() != null && menuItem.getImageFocus() != null) {
			menuComponent.setImage(request.getContextPath() + "/" + menuItem.getImage());
			menuComponent.setAltImage(request.getContextPath() + "/" + menuItem.getImageFocus());
		}
	}
}
