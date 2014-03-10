package vn.jv.persist.repositories;

import vn.jv.persist.BaseRepo;
import vn.jv.persist.domain.Job;

/**
 *
 * @author hunglevn@outlook.com
 *
 */
public interface JobRepo extends BaseRepo<Job, Integer>, JobCustomRepo<Job, Integer> {

}
