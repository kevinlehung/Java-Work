package vn.jv.service;

import java.util.List;

import vn.jv.persist.domain.Job;
import vn.jv.web.bean.JobViewBean;
import vn.jv.web.form.PostJobForm;

/**
 * 
 * @author hunglevn@outlook.com
 *
 */
public interface IJobService extends IBaseService {
	/**
	 * Add new job. Insert data into these tables:
	 * + job
	 * + job_skill
	 * @param postJobForm
	 * @param createdUserId
	 * @return
	 */
	Job postJob(PostJobForm postJobForm, int createdUserId);

	/**
	 * Find jobs with pageIndex criteria
	 *  
	 * @param pageIndex
	 * @return
	 */
	List<JobViewBean> findJobs(int pageIndex);
}
