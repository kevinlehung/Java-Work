package vn.jv.persist.repositories;

import java.util.List;

import vn.jv.persist.BaseRepo;
import vn.jv.persist.domain.ULicense;
import vn.jv.persist.domain.User;

public interface ULicenseRepo extends BaseRepo<ULicense, Integer>, ULicenseCustomRepo<ULicense, Integer> {

	public List<ULicense> findByUser(User user);
}
