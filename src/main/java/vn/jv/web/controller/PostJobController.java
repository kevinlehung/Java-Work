package vn.jv.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import vn.jv.persist.domain.Skill;
import vn.jv.persist.domain.User;
import vn.jv.persist.domain.WorkCategory;
import vn.jv.service.IJobService;
import vn.jv.service.ISkillService;
import vn.jv.service.IWorkCategoryService;
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
public class PostJobController {
	@Autowired
	private IJobService jobService;
	
	@Autowired
	private ISkillService skillService;
	
	@Autowired
	private IWorkCategoryService workCategoryService;
	
	@ModelAttribute("postJobForm")
	public PostJobForm postJobForm() {
		return new PostJobForm(); // populates form for the first time if its null
	}
	 
    @RequestMapping(value = "/u/post_job", method = RequestMethod.GET)
    public String postJob(HttpServletRequest request, HttpServletResponse response, 
    		@ModelAttribute("postJobForm") PostJobForm postJobForm, BindingResult result, Model model) throws IOException {
    	model.addAttribute("postJobForm", postJobForm);
    	List<WorkCategory> workCategories = workCategoryService.findAll();
    	model.addAttribute("workCategories", workCategories);
    	
    	List<Skill> skills = skillService.findAll();
    	model.addAttribute("skills", skills);
    	
        return WebConstants.Views.POST_JOB;
    }
    
    @RequestMapping(value = "/u/post_job/preview", method = RequestMethod.POST)
    public String postJobPreview(HttpServletRequest request, HttpServletResponse response, 
    		@ModelAttribute("postJobForm") PostJobForm postJobForm, BindingResult result, Model model) throws IOException {
    	boolean hasError = result.hasErrors();
		if (!hasError) {
			return WebConstants.Views.POST_JOB_PREVIEW;
		} else {
			return WebConstants.Views.POST_JOB;
		}
    }
    
    @RequestMapping(value = "/u/post_job/done", method = RequestMethod.POST)
    public String postJobDone(HttpServletRequest request, HttpServletResponse response, 
    		@ModelAttribute("postJobForm") PostJobForm postJobForm, BindingResult result, Model model, SessionStatus status) throws IOException {
    	status.setComplete();
    	return WebConstants.Views.POST_JOB_DONE;
    }
    
    @RequestMapping(value = "/u/post_job/cancel", method = RequestMethod.POST)
    public String postJobCancel(HttpServletRequest request, HttpServletResponse response, 
    		@ModelAttribute("postJobForm") PostJobForm postJobForm, BindingResult result, Model model, SessionStatus status) throws IOException {
    	status.setComplete();
    	return WebConstants.Views.POST_JOB_DONE;
    }
}
