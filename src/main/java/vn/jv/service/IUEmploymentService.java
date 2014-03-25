package vn.jv.service;

import java.util.List;

import vn.jv.persist.domain.UEmployment;

/**
 * Contain operations related to UEducation
 * 
 * @author hieutran83
 *
 */
public interface IUEmploymentService extends IBaseService{

	public List<UEmployment> findByUserId(int userId);
}
