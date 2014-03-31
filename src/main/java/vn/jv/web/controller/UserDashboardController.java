package vn.jv.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
import vn.jv.service.IUserService;
import vn.jv.web.common.util.SecurityUtil;
import vn.jv.web.form.UCertificationForm;;

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
	
	@Autowired
	private IUserService userService;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		//binder.addValidators(userSignUpFormValidator);
		SimpleDateFormat dateFormat = new SimpleDateFormat(vn.jv.constant.WebConstants.FixValue.DEFAULT_DATE_FORMAT);
		 dateFormat.setLenient(false);
		 binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@ModelAttribute("uCertificationForm")
	public UCertificationForm uCertificationForm() {
		return new UCertificationForm(); // populates form for the first time if its null
	}
	
	@RequestMapping(value = "/u/dashboard")
	public String viewUserDashboard(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("uCertificationForm") UCertificationForm uCertificationForm, Model model) throws IOException {
		model.addAttribute(uCertificationForm);
		setModelAttributesForViewingUserDashboard(model);
		return WebConstants.Views.USER_PROFILE_OVERVIEW;
	}
	
	@RequestMapping(value = "/u/dashboard/createUCertification", method = RequestMethod.POST)
	public String createUCertification(HttpServletRequest request, HttpServletResponse response,
					@Valid @ModelAttribute UCertificationForm uCertificationForm,
					BindingResult result) throws IOException {
		
		if(!result.hasErrors()) {
			User user = SecurityUtil.getCurrentUser();
			uCertificationService.create(user, uCertificationForm.getConferringOrganization(), 
										uCertificationForm.getProfessionalCertificate(), uCertificationForm.getDateAwarded(),
										uCertificationForm.getCertificateNumber(), uCertificationForm.getDescription());
		}
		
		return WebConstants.Views.USER_PROFILE_OVERVIEW;
	}
	
	@RequestMapping(value = "/u/dashboard/{uCertificationId}/updateUCertification", method = RequestMethod.POST)
	public String updateUCertification(HttpServletRequest request, HttpServletResponse response,
					@Valid @ModelAttribute UCertificationForm uCertificationForm, @PathVariable("uCertificationId") int uCertificationId,
					BindingResult result) throws IOException {
		
		if(!result.hasErrors()) {
			uCertificationService.update(uCertificationId, uCertificationForm.getConferringOrganization(), 
										uCertificationForm.getProfessionalCertificate(), uCertificationForm.getDateAwarded(),
										uCertificationForm.getCertificateNumber(), uCertificationForm.getDescription());
		}
		
		return WebConstants.Views.USER_PROFILE_OVERVIEW;
	}
	
	@RequestMapping(value = "/u/dashboard/{uCertificationId}/deleteUCertification")
	public String deleteUCertification(HttpServletRequest request, HttpServletResponse response, 
					@PathVariable("uCertificationId") int uCertificationId) {
		uCertificationService.delete(uCertificationId);
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
