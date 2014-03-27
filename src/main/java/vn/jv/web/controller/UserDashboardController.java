package vn.jv.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.jv.constant.WebConstants;
import vn.jv.persist.domain.User;
import vn.jv.persist.domain.Profile;
import vn.jv.persist.domain.UCertification;
import vn.jv.persist.domain.UEducation;
import vn.jv.persist.domain.UEmployment;
import vn.jv.persist.domain.ULicense;
import vn.jv.service.IProfileService;
import vn.jv.service.IUCertificationService;
import vn.jv.service.IUEducationService;
import vn.jv.service.IUEmploymentService;
import vn.jv.service.IULicenseService;
import vn.jv.web.common.util.SecurityUtil;

/**
 * This controller is for displaying the page: My Account => Overview
 * @author hunglevn@outlook.com
 *
 */
@Controller
public class UserDashboardController extends BaseController {
	
	@Autowired
	private IProfileService profileService;
	
	@Autowired
	private IUCertificationService uCertificationService;
	
	@Autowired
	private IUEducationService uEducationService;
	
	@Autowired
	private IUEmploymentService uEmploymentService;
	
	@Autowired
	private IULicenseService uLicenseService;
	
	@RequestMapping("/u/dashboard")
	public String viewUserDashboard(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		
		setModelAttributesForViewingUserDashboard(model);
		return WebConstants.Views.USER_PROFILE_OVERVIEW;
	}
	
	private void setModelAttributesForViewingUserDashboard(Model model) {
		User jvUser = SecurityUtil.getCurrentUser();
		
		List<Profile> profiles = profileService.findByUserId(jvUser.getUserId());
		model.addAttribute("profiles", profiles);
		
		List<UCertification> uCertifications = uCertificationService.findByUserId(jvUser.getUserId());
		model.addAttribute("uCertifications", uCertifications);
		
		List<UEducation> uEducations = uEducationService.findByUserId(jvUser.getUserId());
		model.addAttribute("uEducations", uEducations);
		
		List<UEmployment> uEmployments = uEmploymentService.findByUserId(jvUser.getUserId());
		model.addAttribute("uEmployments", uEmployments);
		
		List<ULicense> uLicenses = uLicenseService.findByUserId(jvUser.getUserId());
		model.addAttribute("uLicenses", uLicenses);
	}
}
