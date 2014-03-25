package vn.jv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import vn.jv.persist.domain.UCertification;
import vn.jv.persist.domain.User;
import vn.jv.persist.repositories.UCertificationRepo;

/**
 * Contain operations related to UCertification
 * 
 * @author hieutran83
 *
 */
@Service("uCertificationService")
public class UCertificationService extends BaseService implements IUCertificationService {

	@Autowired
	UCertificationRepo uCertificationRepo;
	
	@Cacheable(value = "UCertificationService.findByUserId", key="#userId")
	public List<UCertification> findByUserId(int userId) {
		return uCertificationRepo.findByUser(new User(userId));
	}
}
