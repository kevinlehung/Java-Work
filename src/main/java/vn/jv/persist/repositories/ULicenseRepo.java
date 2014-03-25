package vn.jv.persist.repositories;

import vn.jv.persist.domain.ULicense;
import vn.jv.persist.BaseRepo;

public interface ULicenseRepo extends BaseRepo<ULicense, Integer>, ULicenseCustomRepo<ULicense, Integer> {

}
