package vn.jv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import vn.jv.persist.domain.ULicense;
import vn.jv.persist.domain.User;
import vn.jv.persist.repositories.ULicenseRepo;

/**
 * Contain operations related to ULicense
 * 
 * @author hieu.tran
 *
 */
@Service("uLicenseService")
public class ULicenseService extends BaseService implements IULicenseService {

	@Autowired
	ULicenseRepo uLicenseRepo;
	
	@Cacheable(value = "ULicenseService.findByUserId", key="#userId")
	public List<ULicense> findByUserId(int userId) {
		return uLicenseRepo.findByUser(new User(userId));
	}

}
