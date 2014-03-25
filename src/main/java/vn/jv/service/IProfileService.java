package vn.jv.service;

import java.util.List;

import vn.jv.persist.domain.Profile;

/**
 * Contain operations related to Profile
 * 
 * @author hieutran83
 *
 */
public interface IProfileService extends IBaseService {
	public List<Profile> findByUserId(int userId);
}
