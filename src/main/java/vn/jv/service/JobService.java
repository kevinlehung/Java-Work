package vn.jv.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import vn.jv.persist.domain.City;
import vn.jv.persist.domain.Country;
import vn.jv.persist.domain.Job;
import vn.jv.persist.domain.JobSkill;
import vn.jv.persist.domain.Skill;
import vn.jv.persist.domain.User;
import vn.jv.persist.domain.WorkCategory;
import vn.jv.persist.repositories.JobRepo;
import vn.jv.persist.repositories.JobSkillRepo;
import vn.jv.persist.repositories.WorkCategoryRepo;
import vn.jv.web.bean.JobViewBean;
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
	
	@Autowired
	private ILocationService locationService;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Job postJob(PostJobForm postJobForm, int createUserId) {
		Job job = insertJobEntity(postJobForm, createUserId);
		insertJobSkillEntities(postJobForm, job.getJobId());
		return job;
	}

	public List<JobViewBean> findJobs(int pageIndex) {
		List<JobViewBean> jobViewBeans = new ArrayList<JobViewBean>();
		
		final int PAGE_SIZE = 20;
		Sort sort = new Sort(new Order(Direction.DESC, "createdDate"));
		Pageable pageable = new PageRequest(pageIndex, PAGE_SIZE, sort);
		Page<Job> jobs = jobRepo.findAll(pageable);
		
		for (Job job : jobs) {
			JobViewBean jobViewBean = buildJobViewBean(job);
			
			
			jobViewBeans.add(jobViewBean);
		}
		
		return jobViewBeans;
	}
	
	private JobViewBean buildJobViewBean(Job job) {
		JobViewBean jobViewBean = new JobViewBean();
		
		int cityId = job.getCity().getCityId();
		City city = locationService.findCityById(cityId);
		
		int countryId = job.getCountry().getCountryId();
		Country country = locationService.findCountryById(countryId);
		
		jobViewBean.setCity(city);
		return null;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private List<JobSkill> insertJobSkillEntities(PostJobForm postJobForm, int jobId) {
		List<Integer> requiredSkillIds = postJobForm.getRequiredSkillIds();
		if (requiredSkillIds == null) {
			return new ArrayList<JobSkill>();
		}
		
		List<JobSkill> jobSkills = new ArrayList<JobSkill>();
		for (Integer skillId : requiredSkillIds) {
			JobSkill jobSkill = new JobSkill();
			jobSkill.setJob(new Job(jobId));
			jobSkill.setSkill(new Skill(skillId));
			
			jobSkillRepo.save(jobSkill);
			
			jobSkills.add(jobSkill);
		}
		return jobSkills;
		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private Job insertJobEntity(PostJobForm postJobForm, int createUserId) {
		Job job = new Job();
		
		job.setCreateUser(new User(createUserId));
		job.setCreatedDate(new Date());
		job.setCustomRequiredSkill(postJobForm.getCustomRequiredSkill());
		job.setDescription(postJobForm.getDescription());
		job.setOtherOption(postJobForm.getOtherOption());
		job.setSalaryFromAmount(postJobForm.getSalaryFromAmount());
		job.setSalaryToAmount(postJobForm.getSalaryToAmount());
		job.setSalaryType(postJobForm.getSalaryType());
		job.setStatus(Job.Status.OPENING);
		job.setTitle(postJobForm.getTitle());
		job.setWorkCategory(new WorkCategory(postJobForm.getWorkCategoryId()));
		job.setCountry(new Country(postJobForm.getCountryId()));
		job.setCity(new City(postJobForm.getCityId()));
		
		jobRepo.save(job);
		
		return job;
	}
	
	
}
