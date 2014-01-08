package vn.jv.db.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import vn.jv.db.entity.User;
import vn.jv.util.Lib;

@Component
public class UserDAO extends BaseDAO<Integer, User> implements IUserDAO {
	
	public User findByEmail(String email) {
		try {
			String query = "FROM vn.jv.db.entity.User u WHERE u.userEmail = :userEmail";
			Map<String, Object> map = Lib.buildParamsMap("userEmail", email);
			List<User> users = findByNamedQuery(query, map);
			if (users != null && !users.isEmpty()) {
				return users.get(0);
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException("Failed to find user by email [" + email + "]", e);
		}
	}

	public List<User> findByRoleName(String roleName) {
		try {
			String query = "SELECT DISTINCT ru.user FROM AcRoleUser ru JOIN ru.user u JOIN ru.acRole r " +
					"WHERE r.roleName = :roleName";
			Map<String, Object> map = Lib.buildParamsMap("roleName", roleName);
			List<User> list = findByNamedQuery(query, map);
			return list;
		} catch (Exception e) {
			throw new RuntimeException("Failed to find Users by [roleName=" + roleName + "]", e);
		}
	}
	
	public User findByPasswordHash(String passwordHash) {
		try {
			String query = "FROM vn.jv.db.entity.User u WHERE u.passwordHash = :passwordHash";
			Map<String, Object> map = Lib.buildParamsMap("passwordHash", passwordHash);
			List<User> users = findByNamedQuery(query, map);
			if (users != null && !users.isEmpty()) {
				return users.get(0);
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException("Failed to find user by passwordHash [" + passwordHash + "]", e);
		}
	}
	
}
