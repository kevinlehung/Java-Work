package vn.jv.service;

import java.util.List;

import vn.jv.persist.domain.ULicense;

/**
 * Contain operations related to ULicense
 * 
 * @author hieu.tran
 *
 */
public interface IULicenseService extends IBaseService {

	public List<ULicense> findByUserId(int userId);
}
