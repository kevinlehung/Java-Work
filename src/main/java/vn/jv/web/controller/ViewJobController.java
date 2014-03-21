package vn.jv.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.jv.constant.WebConstants;
import vn.jv.persist.repositories.JobRepo;
import vn.jv.service.IJobService;
import vn.jv.web.bean.JobViewBean;

/**
 * 
 * @author hunglevn@outlook.com
 * 
 */
@Controller
public class ViewJobController extends BaseController {
	@Autowired
	private IJobService jobService;
	
	@Autowired
	private JobRepo jobRepo;
	
	@RequestMapping("/u/jobs/{pageIndex}/list")
	public String jobsList(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("pageIndex") int pageIndex, Model model) throws IOException {
		List<JobViewBean> jobs = jobService.findJobs(pageIndex);
		
		model.addAttribute("jobs", jobs);
		
		return WebConstants.Views.JOBS_LIST;
	}
	
	@RequestMapping("/u/jobs/{jobId}/view")
	public String viewJob(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("jobId") int jobId, Model model) throws IOException {
		return WebConstants.Views.JOB_DETAIL;
	}
}
