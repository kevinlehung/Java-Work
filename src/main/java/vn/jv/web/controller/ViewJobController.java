package vn.jv.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.jv.constant.WebConstants;
import vn.jv.persist.domain.Job;
import vn.jv.persist.repositories.JobRepo;
import vn.jv.service.IJobService;

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
		
		
		
		return WebConstants.Views.JOBS_LIST;
	}
	
	
}
