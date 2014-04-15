package vn.jv.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import vn.jv.persist.domain.UCertification;
import vn.jv.persist.domain.User;
import vn.jv.persist.repositories.UCertificationRepo;

/**
 * Contain operations related to UCertification
 * 
 * @author tthieucdl@gmail.com
 *
 */
@Service("uCertificationService")
public class UCertificationService extends BaseService implements IUCertificationService {

	@Autowired
	private UCertificationRepo uCertificationRepo;
	
	//@Cacheable(value = "UCertificationService.findByUserId", key="#userId")
	public List<UCertification> findByUserId(int userId) {
		return this.uCertificationRepo.findByUser(new User(userId));
	}
	
	@CacheEvict(value = "UCertificationService.findByUserId", key="#userId")
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(User user, String conferringOrganization, String professionalCertificate,
			Date dateAwarded, String certificateNumber, String description) {
		
		UCertification uCertification = new UCertification();
		uCertification.setUser(user);
		uCertification.setConferringOrganization(conferringOrganization);
		uCertification.setProfessionalCertificate(professionalCertificate);
		uCertification.setDateAwarded(dateAwarded);
		uCertification.setCertificateNumber(certificateNumber);
		uCertification.setDescription(description);
		
		this.uCertificationRepo.save(uCertification);	
	}
		
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(int uCertificationId, String conferringOrganization, String professionalCertificate,
			Date dateAwarded, String certificateNumber, String description) {
		UCertification uCertification = uCertificationRepo.findOne(uCertificationId);
		// Must check null here or throw item not found? Later
		uCertification.setConferringOrganization(conferringOrganization);
		uCertification.setProfessionalCertificate(professionalCertificate);
		uCertification.setDateAwarded(dateAwarded);
		uCertification.setCertificateNumber(certificateNumber);
		uCertification.setDescription(description);
		
		this.uCertificationRepo.save(uCertification);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(int uCertificationId) {
		uCertificationRepo.delete(uCertificationId);
	}
}
