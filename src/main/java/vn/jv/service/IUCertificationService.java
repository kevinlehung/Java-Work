package vn.jv.service;

import java.util.List;

import vn.jv.persist.domain.UCertification;

/**
 * Contain operations related to UCertification
 * 
 * @author hieutran83
 *
 */
public interface IUCertificationService extends IBaseService{

	public List<UCertification> findByUserId(int userId);
}
