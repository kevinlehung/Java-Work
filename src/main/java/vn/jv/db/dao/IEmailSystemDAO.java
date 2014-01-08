package vn.jv.db.dao;

import vn.jv.db.entity.EmailSystem;

public interface IEmailSystemDAO extends IBaseDAO<Integer, EmailSystem> {
	public EmailSystem getDefaultEmailSystem();
}
