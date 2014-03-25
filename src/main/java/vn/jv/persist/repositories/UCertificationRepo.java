package vn.jv.persist.repositories;

import java.util.List;

import vn.jv.persist.BaseRepo;
import vn.jv.persist.domain.UCertification;
import vn.jv.persist.domain.User;

public interface UCertificationRepo extends BaseRepo<UCertification, Integer>, UCertificationCustomRepo<UCertification, Integer> {

	public List<UCertification> findByUser(User user);
	
}
