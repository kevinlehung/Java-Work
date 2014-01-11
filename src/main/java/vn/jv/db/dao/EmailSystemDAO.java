package vn.jv.db.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import vn.jv.db.entity.EmailSystem;

@Component
public class EmailSystemDAO extends BaseDAO<Integer, EmailSystem> implements IEmailSystemDAO {
	@SuppressWarnings("unchecked")
	public EmailSystem getDefaultEmailSystem() {
		try {
			String query = "FROM EmailSystem es WHERE es.isDefault IS TRUE";
			List<EmailSystem> list = findByQuery(query, null);
			if(list!=null && !list.isEmpty()) {
				return list.get(0);
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException("Failed to find Default Email System", e);
		}
	}
}
