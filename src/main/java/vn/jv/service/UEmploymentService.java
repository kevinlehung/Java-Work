package vn.jv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import vn.jv.persist.domain.UEmployment;
import vn.jv.persist.domain.User;
import vn.jv.persist.repositories.UEmploymentRepo;

/**
 * Contain operations related to UEmployment
 * 
 * @author hieu.tran
 *
 */
@Service("uEmploymentService")
public class UEmploymentService extends BaseService implements IUEmploymentService {

	@Autowired
	UEmploymentRepo uEmploymentRepo;
	
	@Cacheable(value = "UEmploymentService.findByUserId", key="#userId")
	public List<UEmployment> findByUserId(int userId) {
		return uEmploymentRepo.findByUser(new User(userId));
	}

}
