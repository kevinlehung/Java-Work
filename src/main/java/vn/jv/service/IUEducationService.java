package vn.jv.service;

import java.util.List;

import vn.jv.persist.domain.UEducation;

/**
 * Contain operations related to UEducation
 * 
 * @author hieutran83
 *
 */
public interface IUEducationService extends IBaseService {

	List<UEducation> findByUserId(int userId);
}
