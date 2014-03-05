package vn.jv.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import vn.jv.persist.domain.Job;
import vn.jv.persist.domain.JobSkill;
import vn.jv.persist.repositories.JobRepo;
import vn.jv.persist.repositories.JobSkillRepo;
import vn.jv.persist.repositories.WorkCategoryRepo;
import vn.jv.web.form.PostJobForm;

/**
 * 
 * @author hunglevn@outlook.com
 *
 */
@Service
public class JobService implements IJobService {
	@Autowired
	private WorkCategoryRepo workCategoryRepo;

	@Autowired
	private JobSkillRepo jobSkillRepo;
	
	@Autowired
	private JobRepo jobRepo;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Job postJob(PostJobForm postJobForm, int createUserId) {
		Job job = insertJobEntity(postJobForm, createUserId);
		insertJobSkillEntities(postJobForm, job.getJobId());
		return job;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private List<JobSkill> insertJobSkillEntities(PostJobForm postJobForm, int jobId) {
		List<JobSkill> jobSkills = new ArrayList<JobSkill>();
		List<Integer> requiredSkillIds = postJobForm.getRequiredSkillIds();
		for (Integer skillId : requiredSkillIds) {
			JobSkill jobSkill = new JobSkill();
			jobSkill.setJobId(jobId);
			jobSkill.setSkillId(skillId);

			jobSkillRepo.save(jobSkill);
			
			jobSkills.add(jobSkill);
			if (true == true) {
				throw new RuntimeException();
			}
		}
		return jobSkills;
		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private Job insertJobEntity(PostJobForm postJobForm, int createUserId) {
		Job job = new Job();
		
		job.setCreateUserId(createUserId);
		job.setCreatedDate(new Date());
		job.setCustomRequiredSkill(postJobForm.getCustomRequiredSkill());
		job.setDescription(postJobForm.getDescription());
		job.setOtherOption(postJobForm.getOtherOption());
		job.setSalaryFromAmount(postJobForm.getSalaryFromAmount());
		job.setSalaryToAmount(postJobForm.getSalaryToAmount());
		job.setSalaryType(postJobForm.getSalaryType());
		job.setStatus(Job.Status.OPENING);
		job.setTitle(postJobForm.getTitle());
		job.setWorkCategoryId(postJobForm.getWorkCategoryId());
		
		jobRepo.save(job);
		
		return job;
	}
}
