package vn.jv.web.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import vn.jv.constant.WebConstants;
import vn.jv.persist.domain.Job;
import vn.jv.persist.domain.Skill;
import vn.jv.persist.domain.User;
import vn.jv.persist.repositories.JobRepo;
import vn.jv.security.bean.JvUserDetails;
import vn.jv.service.IJobService;
import vn.jv.service.ISkillService;
import vn.jv.web.bean.JobViewBean;
import vn.jv.web.common.util.SecurityUtil;
import vn.jv.web.common.util.WebHelper;
import vn.jv.web.form.PostJobForm;

/**
 * 
 * @author hunglevn@outlook.com
 * 
 */
@Controller
@SessionAttributes("jobs")
public class ViewJobController extends BaseController {
	@Autowired
	private WebHelper webHelper;
	
	@Autowired
	private ISkillService skillService;
	
	@Autowired
	private IJobService jobService;
	
	@Autowired
	private JobRepo jobRepo;
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param pageIndex this value is started from ONE. 
	 * 		  While [jobService.findJobs] is ZERO BASE, it is minus 1 before pass to that method.
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/u/jobs/{pageIndex}/list")
	public String jobsList(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("pageIndex") int pageIndex, Model model) throws IOException {
		
		Page<Job> page = jobService.getJobPageInfo(pageIndex - 1);
		List<JobViewBean> jobs = jobService.findJobsViewBean(pageIndex - 1, page);
		
		model.addAttribute("jobs", jobs);
		model.addAttribute("page", page);
		
		int current = page.getNumber() + 1;
	    int begin = 1;
	    int end = page.getTotalPages();
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		
		return WebConstants.Views.JOBS_LIST;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/u/jobs/{jobId}/view")
	public String viewJob(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("jobId") int jobId, ModelMap model) throws IOException {
		List<JobViewBean> jobs = (List<JobViewBean>) model.get("jobs");
		for(JobViewBean job : jobs) {
			if(job.getJobId() == jobId){
				setModelAttributesForJobDetail(job, model);
				break;
			}
		}
		return WebConstants.Views.JOB_DETAIL;
	}
	
	private void setModelAttributesForJobDetail(JobViewBean jobViewBean,
			ModelMap model) {
		
		model.addAttribute("title", jobViewBean.getTitle());
		
		model.addAttribute("location", jobViewBean.getLocation());
		
		model.addAttribute("createdDate", jobViewBean.getCreatedDate());
		
		String salaryType = webHelper.buildSalaryTypeText(jobViewBean.getSalaryType());
		model.addAttribute("salaryType", salaryType);
		
		String salary = webHelper.buildSalaryText(jobViewBean.getSalaryFromAmount(), jobViewBean.getSalaryToAmount());
		model.addAttribute("salary", salary);
		
		String company = buildComapnyText();
		model.addAttribute("company", company);
		
		model.addAttribute("jobType", jobViewBean.getJobType());
		
		model.addAttribute("appliedCount", jobViewBean.getAppliedCount());
		
		model.addAttribute("description", jobViewBean.getDescription());
	
		model.addAttribute("requiredSkills", jobViewBean.getRequiredSkills());
		
		model.addAttribute("customRequiredSkill", jobViewBean.getCustomRequiredSkill());
	}
	
	private String buildComapnyText() {
		JvUserDetails userDetail = SecurityUtil.getUserDetail();
		User jvUser = userDetail.getJvUser();
		String clientInfo = "Hidden";
		if (jvUser.getFirstName() != null || jvUser.getLastName() != null) {
			clientInfo = String.format("%s %s", jvUser.getFirstName(), jvUser.getLastName());
		}
		return clientInfo;
	}
}
