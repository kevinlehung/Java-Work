package vn.jv.service;

import java.util.List;

import vn.jv.persist.domain.Profile;
import vn.jv.persist.domain.User;

/**
 * Contain operations related to Profile
 * 
 * @author hieutran83
 *
 */
public interface IProfileService extends IBaseService {
	public List<Profile> findByUserId(int userId);
	
	public Profile findOneByUserId(int userId);
	
	public void create(User user, vn.jv.persist.domain.File file,
					String tagline, String overview, int hourlyRate,
					String experience, String serviceDescription);
	
	public void update(int profileId, vn.jv.persist.domain.File file, 
					String tagline, String overview, int hourlyRate,
					String experience, String serviceDescription);
	
	public void delete(int profileId);
}
