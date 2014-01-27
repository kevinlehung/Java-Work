package vn.jv.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import vn.jv.constant.WebConstants;
import vn.jv.web.form.PostJobForm;

@Controller
@SessionAttributes("postJobForm")
public class PostJobController {
	 
    @RequestMapping("/u/post_job")
    public String postJob(HttpServletRequest request, HttpServletResponse response, 
    		@ModelAttribute PostJobForm PostJobForm, BindingResult result, Model model) throws IOException {
        return WebConstants.Views.POST_JOB;
    }
    
    @RequestMapping("/u/post_job/preview")
    public String postJobPreview(HttpServletRequest request, HttpServletResponse response, 
    		@ModelAttribute PostJobForm postJobForm, BindingResult result, Model model) throws IOException {
        return WebConstants.Views.POST_JOB_PREVIEW;
    }
    
    @RequestMapping("/u/post_job/done")
    public String postJobDone(HttpServletRequest request, HttpServletResponse response, 
    		@ModelAttribute PostJobForm postJobForm, BindingResult result, Model model, SessionStatus status) throws IOException {
    	status.setComplete();
    	return WebConstants.Views.POST_JOB_DONE;
    }
    
    @RequestMapping("/u/post_job/cancel")
    public String postJobCancel(HttpServletRequest request, HttpServletResponse response, 
    		@ModelAttribute PostJobForm postJobForm, BindingResult result, Model model, SessionStatus status) throws IOException {
    	status.setComplete();
    	return WebConstants.Views.POST_JOB_DONE;
    }
}
