package vn.jv.persist.repositories;

import vn.jv.persist.BaseRepo;
import vn.jv.persist.domain.Profile;

public interface ProfileRepo extends BaseRepo<Profile, Integer>, ProfileCustomRepo<Profile, Integer> {

}
