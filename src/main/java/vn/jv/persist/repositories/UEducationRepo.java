package vn.jv.persist.repositories;

import java.util.List;

import vn.jv.persist.BaseRepo;
import vn.jv.persist.domain.UEducation;
import vn.jv.persist.domain.User;

public interface UEducationRepo extends BaseRepo<UEducation, Integer>, UEducationCustomRepo<UEducation, Integer> {

	public List<UEducation> findByUser(User user);
}
