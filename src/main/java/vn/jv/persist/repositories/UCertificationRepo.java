package vn.jv.persist.repositories;

import vn.jv.persist.domain.UCertification;
import vn.jv.persist.BaseRepo;

public interface UCertificationRepo extends BaseRepo<UCertification, Integer>, UCertificationCustomRepo<UCertification, Integer> {

}
