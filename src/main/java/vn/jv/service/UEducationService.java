package vn.jv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import vn.jv.persist.domain.UEducation;
import vn.jv.persist.domain.User;
import vn.jv.persist.repositories.UEducationRepo;

/**
 * Contain operations related to UEducation
 * 
 * @author hieutran83
 *
 */
@Service("uEducationService")
public class UEducationService extends BaseService implements IUEducationService {

	@Autowired
	UEducationRepo uEducationRepo;
	
	@Cacheable(value = "UEducationService.findByUserId", key="#userId")
	public List<UEducation> findByUserId(int userId) {
		return uEducationRepo.findByUser(new User(userId));
	}
}
