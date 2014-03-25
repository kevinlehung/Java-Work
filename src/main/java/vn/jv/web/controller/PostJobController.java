package vn.jv.web.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import vn.jv.constant.WebConstants;
import vn.jv.persist.domain.Country;
import vn.jv.persist.domain.Skill;
import vn.jv.persist.domain.User;
import vn.jv.persist.domain.WorkCategory;
import vn.jv.persist.repositories.CountryRepo;
import vn.jv.security.bean.JvUserDetails;
import vn.jv.service.IJobService;
import vn.jv.service.ILocationService;
import vn.jv.service.ISkillService;
import vn.jv.service.IWorkCategoryService;
import vn.jv.web.bean.CityBean;
import vn.jv.web.common.util.SecurityUtil;
import vn.jv.web.common.util.WebHelper;
import vn.jv.web.form.PostJobForm;

/**
 * Controller for posting job. Include these action:
 * + Show Post Job page.
 * + Preview Job.
 * + Cancel posting job.
 * + Submit job.
 * 
 * @author hunglevn@outlook.com
 *
 */

@Controller
@SessionAttributes("postJobForm")
public class PostJobController extends BaseController {
	@Autowired
	private WebHelper webHelper;
	
	@Autowired
	private IJobService jobService;
	
	@Autowired
	private ILocationService locationService;
	
	@Autowired
	private ISkillService skillService;
	
	@Autowired
	private IWorkCategoryService workCategoryService;
	
	@Autowired
	private CountryRepo countryRepo;
	
	@ModelAttribute("postJobForm")
	public PostJobForm postJobForm() {
		return new PostJobForm(); // populates form for the first time if its null
	}
	 
    @RequestMapping(value = "/u/post_job", method = RequestMethod.GET)
    public String postJob(HttpServletRequest request, HttpServletResponse response, 
    		@ModelAttribute("postJobForm") PostJobForm postJobForm, BindingResult result, Model model, SessionStatus status) throws IOException {
    	status.setComplete();
    	setModelAttributesForPostJob(postJobForm, model);
        return WebConstants.Views.POST_JOB;
    }
    
    @RequestMapping(value = "/u/post_job/preview", method = RequestMethod.POST)
    public String postJobPreview(HttpServletRequest request, HttpServletResponse response, 
    		@Valid @ModelAttribute("postJobForm") PostJobForm postJobForm, BindingResult result, Model model) throws IOException {
    	boolean hasError = result.hasErrors();
		if (!hasError) {
			setModelAttributesForPostJobPreview(postJobForm, model);
			return WebConstants.Views.POST_JOB_PREVIEW;
		} else {
			setModelAttributesForPostJob(postJobForm, model);
			
			return WebConstants.Views.POST_JOB;
		}
    }
    
    @RequestMapping(value = "/u/post_job/done", method = RequestMethod.POST)
    public String postJobDone(HttpServletRequest request, HttpServletResponse response, 
    		@ModelAttribute("postJobForm") PostJobForm postJobForm, BindingResult result, Model model, SessionStatus status) throws IOException {
    	JvUserDetails userDetail = SecurityUtil.getUserDetail();
    	
    	jobService.postJob(postJobForm, userDetail.getJvUser().getUserId());
    	status.setComplete();
    	return WebConstants.Views.POST_JOB_DONE;
    }
    
    @RequestMapping(value = "/u/post_job/cancel", method = RequestMethod.POST)
    public String postJobCancel(HttpServletRequest request, HttpServletResponse response, 
    		@ModelAttribute("postJobForm") PostJobForm postJobForm, BindingResult result, Model model, SessionStatus status) throws IOException {
    	status.setComplete();
    	return WebConstants.Views.POST_JOB_DONE;
    }
	private void setModelAttributesForPostJobPreview(PostJobForm postJobForm,
			Model model) {
		String location = webHelper.buildocationText(postJobForm.getCountryId(), postJobForm.getCityId());
		model.addAttribute("location", location);
		
		String createdDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
		model.addAttribute("createdDate", createdDate);
		
		String salaryType = webHelper.buildSalaryTypeText(postJobForm.getSalaryType());
		model.addAttribute("salaryType", salaryType);
		
		String salary = webHelper.buildSalaryText(postJobForm.getSalaryFromAmount(), postJobForm.getSalaryToAmount());
		model.addAttribute("salary", salary);
		
		String clientInfo = buildClientInfoText();
		model.addAttribute("clientInfo", clientInfo);
		
		List<Skill> requiredSkills = skillService.findByIds(postJobForm.getRequiredSkillIds());
		model.addAttribute("requiredSkills", requiredSkills);
	}

	private String buildClientInfoText() {
		JvUserDetails userDetail = SecurityUtil.getUserDetail();
		User jvUser = userDetail.getJvUser();
		String clientInfo = "Hidden";
		if (jvUser.getFirstName() != null || jvUser.getLastName() != null) {
			clientInfo = String.format("%s %s", jvUser.getFirstName(), jvUser.getLastName());
		}
		return clientInfo;
	}

	private void setModelAttributesForPostJob(PostJobForm postJobForm, Model model) {
		model.addAttribute("postJobForm", postJobForm);
		
		List<Skill> skills = skillService.findAll();
		model.addAttribute("skills", skills);
		
		List<WorkCategory> workCategories = workCategoryService.findAll();
		workCategories.add(0, new WorkCategory(0, "Select", "Select"));
		model.addAttribute("workCategories", workCategories);
		
		List<Country> countries = countryRepo.findAll();
		countries.add(0, new Country(0, "Select a country"));
		model.addAttribute("countries", countries);
		
		int selectedCountryId = postJobForm.getCountryId();
		if (selectedCountryId != 0) {
			List<CityBean> cityBeans = locationService.findByCountryId(selectedCountryId);
			cityBeans.add(0, new CityBean(0, "Select", 0));
			model.addAttribute("cities", cityBeans);
		}
	}

	
}
