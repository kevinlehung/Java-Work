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
import vn.jv.web.form.UCertificationForm;
import vn.jv.web.form.UEducationForm;
import vn.jv.web.form.UEmploymentForm;
import vn.jv.web.form.ULicenseForm;

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
	
	@ModelAttribute("uEducationForm")
	public UEducationForm uEducationForm() {
		return new UEducationForm();
	}
	
	@ModelAttribute("uEmploymentForm")
	public UEmployment uEmploymentForm() {
		return new UEmployment();
	}
	
	@ModelAttribute("uLicenseForm")
	public ULicenseForm uLicenseForm() {
		return new ULicenseForm();
	}
	
	@RequestMapping(value = "/u/dashboard")
	public String viewUserDashboard(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("uCertificationForm") UCertificationForm uCertificationForm, Model model) {
		model.addAttribute(uCertificationForm);
		setModelAttributesForViewingUserDashboard(model);
		return WebConstants.Views.USER_PROFILE_OVERVIEW;
	}
	
	/** UCertification */
	@RequestMapping(value = "/u/dashboard/createUCertification", method = RequestMethod.POST)
	public String createUCertification(HttpServletRequest request, HttpServletResponse response,
					@Valid @ModelAttribute UCertificationForm uCertificationForm,
					BindingResult result) {
		
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
					@Valid @ModelAttribute UCertificationForm uCertificationForm, BindingResult result, 
					@PathVariable("uCertificationId") int uCertificationId) {
		
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
	
	/** UEducation */
	
	@RequestMapping(value = "/u/dashboard/createUEducation")
	public String createUEducation(HttpServletRequest request, HttpServletResponse reponse,
					@Valid @ModelAttribute UEducationForm uEducationForm,
					BindingResult result) {
		if(!result.hasErrors()) {
			User user = SecurityUtil.getCurrentUser();
			uEducationService.create(user, uEducationForm.getInstitutionName(), uEducationForm.getDegreeType(),
									uEducationForm.getGraduationStartDate(), uEducationForm.getGraduationEndDate(),
									uEducationForm.getDescription());
		}
		
		return WebConstants.Views.USER_PROFILE_OVERVIEW;
	}
	
	@RequestMapping(value = "/u/dashboard/{uEducationId}/updateUEducation")
	public String updateUEducation(HttpServletRequest request, HttpServletResponse reponse,
					@Valid @ModelAttribute UEducationForm uEducationForm, BindingResult result,
					@PathVariable("uEducationId") int uEducationId) {
		if(!result.hasErrors()) {
			uEducationService.update(uEducationId, uEducationForm.getInstitutionName(), uEducationForm.getDegreeType(),
									uEducationForm.getGraduationStartDate(), uEducationForm.getGraduationEndDate(),
									uEducationForm.getDescription());
		}
		
		return WebConstants.Views.USER_PROFILE_OVERVIEW;
	}
	
	@RequestMapping(value = "/u/dashboard/{uEducationId}/deleteUEducation")
	public String deleteUEducation(HttpServletRequest request, HttpServletResponse response, 
			@PathVariable("uEducationId") int uEducationId) {
		uEducationService.delete(uEducationId);
		return WebConstants.Views.USER_PROFILE_OVERVIEW;
	}
	
	/** UEmployment */
	
	@RequestMapping(value = "/u/dashboard/createUEmployment")
	public String createUEmployment(HttpServletRequest request, HttpServletResponse response,
					@Valid @ModelAttribute UEmploymentForm uEmploymentForm, BindingResult result) {
		if(!result.hasErrors()) {
			User user = SecurityUtil.getCurrentUser();
			uEmploymentService.create(user, uEmploymentForm.getClientName(), uEmploymentForm.getPositionHeld(),
									uEmploymentForm.getStartDate(), uEmploymentForm.getEndDate(),
									uEmploymentForm.getDescription());
		}
		
		return WebConstants.Views.USER_PROFILE_OVERVIEW;
	}
	
	@RequestMapping(value = "/u/dashboard/{uEmploymentId}/updateUEmployment")
	public String updateUEmployemnt(HttpServletRequest request, HttpServletResponse response,
					@Valid @ModelAttribute UEmploymentForm uEmploymentForm, BindingResult result,
					@PathVariable("uEmploymentId") int uEmploymentId) {
		if(!result.hasErrors()) {
			uEmploymentService.update(uEmploymentId, uEmploymentForm.getClientName(), uEmploymentForm.getPositionHeld(),
									uEmploymentForm.getStartDate(), uEmploymentForm.getEndDate(),
									uEmploymentForm.getDescription());
		}
		
		return WebConstants.Views.USER_PROFILE_OVERVIEW;
	}
	
	@RequestMapping(value = "/u/dashboard/{uEmploymentId}/deleteUEmployment")
	public String deleteUEmployment(HttpServletRequest request, HttpServletResponse response,
					@PathVariable("uEmploymentId") int uEmploymentId) {
		uEmploymentService.delete(uEmploymentId);
	
		return WebConstants.Views.USER_PROFILE_OVERVIEW;
	}
	
	/** ULicense */
	
	@RequestMapping(value = "/u/dashboard/createULicense")
	public String createULicense(HttpServletRequest request, HttpServletResponse response,
								@Valid @ModelAttribute ULicenseForm uLicenseForm, BindingResult result) {
		if(!result.hasErrors()) {
			User user = SecurityUtil.getCurrentUser();
			uLicenseService.create(user, uLicenseForm.getConferringOrganization(), uLicenseForm.getProfessionalLicense(),
								uLicenseForm.getDateIssued(), uLicenseForm.getLicenseNumber(), uLicenseForm.getDescription());
		}
		
		return WebConstants.Views.USER_PROFILE_OVERVIEW;
	}
	
	@RequestMapping(value = "/u/dashboard/{uLicenseId}/updateULicense")
	public String updateULicense(HttpServletRequest request, HttpServletResponse response,
					@Valid @ModelAttribute ULicenseForm uLicenseForm, BindingResult result,
					@PathVariable("uLicenseId") int uLicenseId) {
		if(!result.hasErrors()) {
			uLicenseService.update(uLicenseId, uLicenseForm.getConferringOrganization(), uLicenseForm.getProfessionalLicense(),
								uLicenseForm.getDateIssued(), uLicenseForm.getLicenseNumber(), uLicenseForm.getDescription());
		}
		
		return WebConstants.Views.USER_PROFILE_OVERVIEW;
	}
	
	@RequestMapping(value = "/u/dashboard/{uLicenseId}/deleteULicense")
	public String deleteULicense(HttpServletRequest request, HttpServletResponse response,
					@PathVariable("uLicenseId") int uLicenseId) {
		uLicenseService.delete(uLicenseId);
		
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
