package vn.jv.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
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
import vn.jv.persist.repositories.SkillRepo;
import vn.jv.persist.repositories.WorkCategoryRepo;
import vn.jv.web.bean.JobViewBean;
import vn.jv.web.common.util.WebHelper;
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
	private SkillRepo skillRepo;
	
	@Autowired
	private ILocationService locationService;
	
	@Autowired
	private WebHelper webHelper;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Job postJob(PostJobForm postJobForm, int createUserId) {
		Job job = insertJobEntity(postJobForm, createUserId);
		insertJobSkillEntities(postJobForm, job.getJobId());
		return job;
	}

	final int PAGE_SIZE = 5;
	/**
	 * pageIndex: this value is ZERO base
	 */
	public Page<Job> getJobPageInfo(int pageIndex) {
		
		Sort sort = new Sort(new Order(Direction.DESC, "createdDate"));
		Pageable pageable = new PageRequest(pageIndex, PAGE_SIZE, sort);
		Page<Job> page = jobRepo.findAll(pageable);
		
		return page;
	}
	
	public List<JobViewBean> findJobsViewBean(int pageIndex, Page<Job> page) {
		List<JobViewBean> jobViewBeans = new ArrayList<JobViewBean>();
		
		for (Job job : page) {
			JobViewBean jobViewBean = buildJobViewBean(job);
			jobViewBeans.add(jobViewBean);
		}
		
		return jobViewBeans;
	}
	
	/**
	 * pageIndex: this value is ZERO base
	 */
	public List<JobViewBean> findJobs(int pageIndex) {
		List<JobViewBean> jobViewBeans = new ArrayList<JobViewBean>();
		
		for (Job job : getJobPageInfo(pageIndex)) {
			JobViewBean jobViewBean = buildJobViewBean(job);
			
			jobViewBeans.add(jobViewBean);
		}
		
		return jobViewBeans;
	}
	
	private JobViewBean buildJobViewBean(Job job) {
		JobViewBean jobViewBean = new JobViewBean();
		
		BeanUtils.copyProperties(job, jobViewBean);
		
		int cityId = job.getCity() != null ? job.getCity().getCityId() : 0;
		
		int countryId = job.getCountry() != null ? job.getCountry().getCountryId() : 0;
		
		String location = webHelper.buildocationText(countryId, cityId);
		jobViewBean.setLocation(location);
		
		List<Skill> requiredSkills = new ArrayList<Skill>();
		List<JobSkill> jobSkills = jobSkillRepo.findByJob(job);
		if (jobSkills != null) {
			for (JobSkill jobSkill : jobSkills) {
				Skill skill = jobSkill.getSkill();
				skill = skillRepo.findOne(skill.getSkillId());
				requiredSkills.add(skill);
			}
		}
		jobViewBean.setRequiredSkills(requiredSkills);
		
		WorkCategory workCategory = job.getWorkCategory();
		workCategory = workCategoryRepo.findOne(workCategory.getWorkCategoryId());
		jobViewBean.setWorkCategory(workCategory);
		
		String salary = webHelper.buildSalaryText((long)job.getSalaryFromAmount(), (long)job.getSalaryToAmount());
		jobViewBean.setSalary(salary);
		
		return jobViewBean;
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
		
		int countryId = postJobForm.getCountryId();
		if (countryId > 0)
		job.setCountry(new Country(countryId));
		
		int cityId = postJobForm.getCityId();
		if (cityId > 0) {
			job.setCity(new City(cityId));
		}
		
		jobRepo.save(job);
		
		return job;
	}
	
	
}
