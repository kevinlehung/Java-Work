package vn.jv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import vn.jv.persist.domain.Profile;
import vn.jv.persist.domain.User;
import vn.jv.persist.repositories.ProfileRepo;

/**
 * Contain operations related to Profile
 * 
 * @author hieutran83
 *
 */
@Service("profileService")
public class ProfileService extends BaseService implements IProfileService {
	
	@Autowired
	ProfileRepo profileRepo;

	@Cacheable(value = "ProfileService.findByUserId", key="#userId")
	public List<Profile> findByUserId(int userId) {
	
		return profileRepo.findByUser(new User(userId));
	}
}
