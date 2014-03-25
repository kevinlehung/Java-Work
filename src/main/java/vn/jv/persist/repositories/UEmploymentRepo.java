package vn.jv.persist.repositories;

import java.util.List;

import vn.jv.persist.BaseRepo;
import vn.jv.persist.domain.UEmployment;
import vn.jv.persist.domain.User;

public interface UEmploymentRepo extends BaseRepo<UEmployment, Integer>, UEducationCustomRepo<UEmployment, Integer> {

	public List<UEmployment> findByUser(User user);
}
