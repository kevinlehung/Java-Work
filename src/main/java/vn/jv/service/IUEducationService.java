package vn.jv.service;

import java.util.Date;
import java.util.List;

import vn.jv.persist.domain.UEducation;
import vn.jv.persist.domain.User;

/**
 * Contain operations related to UEducation
 * 
 * @author tthieucdl@gmail.com
 *
 */
public interface IUEducationService extends IBaseService {

	public List<UEducation> findByUserId(int userId);
	
	public void create(User user, String institutionName, String degreeType, Date graduationStartDate, 
						Date graduationEndDate, String description);
	
	public void update(int uEducationId, String institutionName, String degreeType, 
						Date graduationStartDate, Date graduationEndDate, String description);
	
	public void delete(int uEducationId);
}
