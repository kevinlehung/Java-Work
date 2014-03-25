package vn.jv.persist.repositories;

import java.util.List;

import vn.jv.persist.BaseRepo;
import vn.jv.persist.domain.Profile;
import vn.jv.persist.domain.User;


public interface ProfileRepo extends BaseRepo<Profile, Integer>, ProfileCustomRepo<Profile, Integer> {

	List<Profile> findByUser(User user);

}
