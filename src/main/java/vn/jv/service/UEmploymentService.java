package vn.jv.service;

import java.util.Date;
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
 * @author tthieucdl@gmail.com
 *
 */
@Service("uEmploymentService")
public class UEmploymentService extends BaseService implements IUEmploymentService {

	@Autowired
	private UEmploymentRepo uEmploymentRepo;
	
	//@Cacheable(value = "UEmploymentService.findByUserId", key="#userId")
	public List<UEmployment> findByUserId(int userId) {
		return uEmploymentRepo.findByUser(new User(userId));
	}
	
	public void create(User user, String clientName, String positionHeld,
			Date startDate, Date endDate, String description) {
		UEmployment uEmployment = new UEmployment();
		uEmployment.setUser(user);
		uEmployment.setClientName(clientName);
		uEmployment.setPositionHeld(positionHeld);
		uEmployment.setStartDate(startDate);
		uEmployment.setEndDate(endDate);
		uEmployment.setDescription(description);
		
		this.uEmploymentRepo.save(uEmployment);
	}
	
	public void update(int uEmploymentId, String clientName, String positionHeld, 
			Date startDate, Date endDate, String description) {
		UEmployment uEmployment = this.uEmploymentRepo.findOne(uEmploymentId);
		// Must check null here or throw item not found? Later
		uEmployment.setClientName(clientName);
		uEmployment.setPositionHeld(positionHeld);
		uEmployment.setStartDate(startDate);
		uEmployment.setEndDate(endDate);
		uEmployment.setDescription(description);
		
		this.uEmploymentRepo.save(uEmployment);
	}
	
	public void delete(int uEmploymentId) {
		this.uEmploymentRepo.delete(uEmploymentId);
	}
}
