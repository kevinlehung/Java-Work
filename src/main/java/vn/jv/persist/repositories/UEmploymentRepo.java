package vn.jv.persist.repositories;

import vn.jv.persist.domain.UEmployment;
import vn.jv.persist.BaseRepo;

public interface UEmploymentRepo extends BaseRepo<UEmployment, Integer>, UEducationCustomRepo<UEmployment, Integer> {

}
