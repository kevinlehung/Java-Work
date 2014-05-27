package vn.jv.web.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
import vn.jv.web.form.ProfileForm;
import vn.jv.web.form.UCertificationForm;
import vn.jv.web.form.UEducationForm;
import vn.jv.web.form.UEmploymentForm;
import vn.jv.web.form.ULicenseForm;
import vn.jv.web.validator.ProfileFormValidator;

/**
 * This controller is for displaying the page: My Account => Overview
 * @author hunglevn@outlook.com
 *
 */
@Controller
public class UserDashboardController extends BaseController {
	
	private static final String BINDING_RESULT_ADDED_CERTIFICATION = "bindingResultAddedCertification";
	private static final String BINDING_RESULT_UPDATED_CERTIFICATION = "bindingResultUpdatedCertification";
	private static final String BINDING_RESULT_ADDED_EDUCATION = "bindingResultAddedEducation";
	private static final String BINDING_RESULT_UPDATED_EDUCATION = "bindingResultUpdatedEducation";
	private static final String BINDING_RESULT_ADDED_EMPLOYMENT = "bindingResultAddedEmployment";
	private static final String BINDING_RESULT_UPDATED_EMPLOYMENT = "bindingResultUpdatedEmployment";
	private static final String BINDING_RESULT_ADDED_LICENSE = "bindingResultAddedLicense";
	private static final String BINDING_RESULT_UPDATED_LICENSE = "bindingResultUpdatedLicense";
	private static final String BINDING_RESULT_UPDATED_OVERVIEW = "bindingResultUpdatedOverview";
	private static final String BINDING_RESULT_UPDATED_SERVICE_DESCRIPTION = "bindingResultUpdatedServiceDescription";
	
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
		SimpleDateFormat dateFormat = new SimpleDateFormat(vn.jv.constant.WebConstants.FixValue.DEFAULT_DATE_FORMAT);
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@InitBinder("profileForm")
	protected void initProfileBinder(WebDataBinder binder) {
		binder.addValidators(new ProfileFormValidator());
	}
	
	@ModelAttribute("profileForm")
	public ProfileForm profileForm() {
		ProfileForm profileForm = new ProfileForm();
		// just simple check for Overview and ServiceDescription
		profileForm.setSimpleCheck(true);
		
		return profileForm;
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
	public UEmploymentForm uEmploymentForm() {
		return new UEmploymentForm();
	}
	
	@ModelAttribute("uLicenseForm")
	public ULicenseForm uLicenseForm() {
		return new ULicenseForm();
	}
	
	/** View Dash board */
	@RequestMapping(value = "/u/dashboard")
	public String viewUserDashboard(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("profileForm") ProfileForm profileForm,
			@ModelAttribute("uCertificationForm") UCertificationForm uCertificationForm,
			@ModelAttribute("uEducationForm") UEducationForm uEducationForm,
			@ModelAttribute("uEmploymentForm") UEmploymentForm uEmploymentForm,
			@ModelAttribute("uLicenseForm") ULicenseForm uLicenseForm, Model model) {
		
		model.addAttribute(profileForm);
		model.addAttribute(uCertificationForm);
		model.addAttribute(uEducationForm);
		model.addAttribute(uEmploymentForm);
		model.addAttribute(uLicenseForm);
		
		if(model.asMap().containsKey(UserDashboardController.BINDING_RESULT_UPDATED_OVERVIEW)) {
			model.addAttribute("org.springframework.validation.BindingResult.profileForm",
					model.asMap().get(UserDashboardController.BINDING_RESULT_UPDATED_OVERVIEW));
		}
		
		if(model.asMap().containsKey(UserDashboardController.BINDING_RESULT_UPDATED_SERVICE_DESCRIPTION)) {
			model.addAttribute("org.springframework.validation.BindingResult.profileForm",
					model.asMap().get(UserDashboardController.BINDING_RESULT_UPDATED_SERVICE_DESCRIPTION));
		}
		
		if(model.asMap().containsKey(UserDashboardController.BINDING_RESULT_ADDED_CERTIFICATION)) {
			model.addAttribute("org.springframework.validation.BindingResult.uCertificationForm",
					model.asMap().get(UserDashboardController.BINDING_RESULT_ADDED_CERTIFICATION));
		}
		if(model.asMap().containsKey(UserDashboardController.BINDING_RESULT_UPDATED_CERTIFICATION)) {
			model.addAttribute("org.springframework.validation.BindingResult.uCertificationForm",
					model.asMap().get(UserDashboardController.BINDING_RESULT_UPDATED_CERTIFICATION));
		}
		if(model.asMap().containsKey(UserDashboardController.BINDING_RESULT_ADDED_EDUCATION)) {
			model.addAttribute("org.springframework.validation.BindingResult.uEducationForm",
					model.asMap().get(UserDashboardController.BINDING_RESULT_ADDED_EDUCATION));
		}
		if(model.asMap().containsKey(UserDashboardController.BINDING_RESULT_UPDATED_EDUCATION)) {
			model.addAttribute("org.springframework.validation.BindingResult.uEducationForm",
					model.asMap().get(UserDashboardController.BINDING_RESULT_UPDATED_EDUCATION));
		}
		if(model.asMap().containsKey(UserDashboardController.BINDING_RESULT_ADDED_EMPLOYMENT)) {
			model.addAttribute("org.springframework.validation.BindingResult.uEmploymentForm",
					model.asMap().get(UserDashboardController.BINDING_RESULT_UPDATED_EMPLOYMENT));
		}
		if(model.asMap().containsKey(UserDashboardController.BINDING_RESULT_ADDED_LICENSE)) {
			model.addAttribute("org.springframework.validation.BindingResult.uLicenseForm",
					model.asMap().get(UserDashboardController.BINDING_RESULT_ADDED_LICENSE));
		}
		if(model.asMap().containsKey(UserDashboardController.BINDING_RESULT_UPDATED_LICENSE)) {
			model.addAttribute("org.springframework.validation.BindingResult.uLicenseForm",
					model.asMap().get(UserDashboardController.BINDING_RESULT_UPDATED_LICENSE));
		}
		
		setModelAttributesForViewingUserDashboard(model);
		
		return WebConstants.Views.USER_PROFILE_OVERVIEW;
	}
	
	/** User Profile */
	@RequestMapping(value = "/u/dashboard/updateOverviewProfile", method = RequestMethod.POST)
	public String updateUserProfileOverviewDashBoard(HttpServletRequest request, HttpServletResponse reponse,
					@Valid @ModelAttribute("profileForm") ProfileForm profileForm, BindingResult bindingResult, 
					RedirectAttributes redirectAttributes , Model model) {
		
		// find user's profile first, if not exists -> create one valid profile, if exists already must check valid
		User jvUser = SecurityUtil.getCurrentUser();
		Profile profile = this.profileService.findOneByUserId(jvUser.getUserId());
		if(profile == null) {
			profile = new Profile();
			profile.setFile(null);
			profile.setUser(jvUser);
			profile.setTagline("Empty");
			profile.setExperience("Empty");
			profile.setHourlyRate(0);
			profile.setServiceDescription("Empty");
			profile.setOverview(profileForm.getOverview());
			this.profileService.create(profile.getUser(), profile.getFile(), profile.getTagline(), profile.getOverview(),
										profile.getHourlyRate(), profile.getExperience(), profile.getServiceDescription());
		} else {
			if(!bindingResult.hasErrors()) {
				profile.setOverview(profileForm.getOverview());
				this.profileService.update(profile.getProfileId(), profile.getFile(), profile.getTagline(), profile.getOverview(),
										profile.getHourlyRate(), profile.getExperience(), profile.getServiceDescription());
			} else {
				redirectAttributes.addFlashAttribute("invalidUpdatedOverview", true);
				redirectAttributes.addFlashAttribute("profileForm", profileForm);
				redirectAttributes.addFlashAttribute(UserDashboardController.BINDING_RESULT_UPDATED_OVERVIEW, bindingResult);
			}
		}
		
		setModelAttributesForViewingUserDashboard(model);
		return "redirect:/" + WebConstants.Pages.USER_PROFILE_OVERVIEW;
	}
	
	@RequestMapping(value = "/u/dashboard/updateServiceDescriptionProfile", method = RequestMethod.POST)
	public String updateUserProfileServiceDescriptionDashBoard(HttpServletRequest request, HttpServletResponse reponse,
					@Valid @ModelAttribute("profileForm") ProfileForm profileForm, BindingResult bindingResult,
					RedirectAttributes redirectAttributes , Model model) {
		
		// find user's profile first, if not exists -> create one valid profile, if exists already must check valid
		User jvUser = SecurityUtil.getCurrentUser();
		Profile profile = this.profileService.findOneByUserId(jvUser.getUserId());
		if(profile == null) {
			profile = new Profile();
			profile.setFile(null);
			profile.setUser(jvUser);
			profile.setTagline("Empty");
			profile.setExperience("Empty");
			profile.setHourlyRate(0);
			profile.setOverview("Empty");
			profile.setServiceDescription(profileForm.getServiceDescription());
			this.profileService.create(profile.getUser(), profile.getFile(), profile.getTagline(), profile.getOverview(),
										profile.getHourlyRate(), profile.getExperience(), profile.getServiceDescription());
		} else {
			if(!bindingResult.hasErrors()) {
				profile.setServiceDescription(profileForm.getServiceDescription());
				this.profileService.update(profile.getProfileId(), profile.getFile(), profile.getTagline(), profile.getOverview(),
										profile.getHourlyRate(), profile.getExperience(), profile.getServiceDescription());
			} else {
				redirectAttributes.addFlashAttribute("invalidUpdatedServiceDescription", true);
				redirectAttributes.addFlashAttribute("profileForm", profileForm);
				redirectAttributes.addFlashAttribute(UserDashboardController.BINDING_RESULT_UPDATED_SERVICE_DESCRIPTION, bindingResult);
			}
		}
		
		setModelAttributesForViewingUserDashboard(model);
		return "redirect:/" + WebConstants.Pages.USER_PROFILE_OVERVIEW;
	}
	
	/** UCertification */
	@RequestMapping(value = "/u/dashboard/createUCertification", method = RequestMethod.POST)
	public String createUCertification(HttpServletRequest request, HttpServletResponse response,
					@Valid @ModelAttribute("uCertificationForm") UCertificationForm uCertificationForm,
					BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
		
		if(!bindingResult.hasErrors()) {
			User user = SecurityUtil.getCurrentUser();
			uCertificationService.create(user, uCertificationForm.getConferringOrganization(), 
										uCertificationForm.getProfessionalCertificate(), uCertificationForm.getDateAwarded(),
										uCertificationForm.getCertificateNumber(), uCertificationForm.getDescription());
		} else {
			redirectAttributes.addFlashAttribute("invalidCreatedCertification", true);
			redirectAttributes.addFlashAttribute("uCertificationForm", uCertificationForm);
			redirectAttributes.addFlashAttribute(UserDashboardController.BINDING_RESULT_ADDED_CERTIFICATION, bindingResult);
		}
		
		setModelAttributesForViewingUserDashboard(model);
		return "redirect:/" + WebConstants.Pages.USER_PROFILE_OVERVIEW;
	}
	
	@RequestMapping(value = "/u/dashboard/{uCertificationId}/updateUCertification", method = RequestMethod.POST)
	public String updateUCertification(HttpServletRequest request, HttpServletResponse response,
					@Valid @ModelAttribute("uCertificationForm") UCertificationForm uCertificationForm,
					BindingResult bindingResult, @PathVariable("uCertificationId") int uCertificationId,
					RedirectAttributes redirectAttributes , Model model) {
		
		if(!bindingResult.hasErrors()) {
			uCertificationService.update(uCertificationId, uCertificationForm.getConferringOrganization(), 
										uCertificationForm.getProfessionalCertificate(), uCertificationForm.getDateAwarded(),
										uCertificationForm.getCertificateNumber(), uCertificationForm.getDescription());
		} else {
			redirectAttributes.addFlashAttribute("invalidUpdatedCertification", true);
			redirectAttributes.addFlashAttribute("uCertificationForm", uCertificationForm);
			redirectAttributes.addFlashAttribute(UserDashboardController.BINDING_RESULT_UPDATED_CERTIFICATION, bindingResult);
		}
		
		setModelAttributesForViewingUserDashboard(model);
		return "redirect:/" + WebConstants.Pages.USER_PROFILE_OVERVIEW;
	}
	
	@RequestMapping(value = "/u/dashboard/{uCertificationId}/deleteUCertification")
	public String deleteUCertification(HttpServletRequest request, HttpServletResponse response, 
					@PathVariable("uCertificationId") int uCertificationId, Model model) {
		uCertificationService.delete(uCertificationId);
		setModelAttributesForViewingUserDashboard(model);
		return "redirect:/" + WebConstants.Pages.USER_PROFILE_OVERVIEW;
	}
	
	/** UEducation */
	
	@RequestMapping(value = "/u/dashboard/createUEducation")
	public String createUEducation(HttpServletRequest request, HttpServletResponse reponse,
					@Valid @ModelAttribute("uEducationForm") UEducationForm uEducationForm,
					BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
		if(!bindingResult.hasErrors()) {
			User user = SecurityUtil.getCurrentUser();
			uEducationService.create(user, uEducationForm.getInstitutionName(), uEducationForm.getDegreeType(),
									uEducationForm.getGraduationStartDate(), uEducationForm.getGraduationEndDate(),
									uEducationForm.getDescription());
		} else {
			redirectAttributes.addFlashAttribute("invalidCreatedEducation", true);
			redirectAttributes.addFlashAttribute("uEducationForm", uEducationForm);
			redirectAttributes.addFlashAttribute(UserDashboardController.BINDING_RESULT_ADDED_EDUCATION, bindingResult);
		}
		
		setModelAttributesForViewingUserDashboard(model);
		return "redirect:/" + WebConstants.Pages.USER_PROFILE_OVERVIEW;
	}
	
	@RequestMapping(value = "/u/dashboard/{uEducationId}/updateUEducation")
	public String updateUEducation(HttpServletRequest request, HttpServletResponse reponse,
					@Valid @ModelAttribute("uEducationForm") UEducationForm uEducationForm,
					BindingResult bindingResult, @PathVariable("uEducationId") int uEducationId,
					RedirectAttributes redirectAttributes, Model model) {
		if(!bindingResult.hasErrors()) {
			uEducationService.update(uEducationId, uEducationForm.getInstitutionName(), uEducationForm.getDegreeType(),
									uEducationForm.getGraduationStartDate(), uEducationForm.getGraduationEndDate(),
									uEducationForm.getDescription());
		} else {
			redirectAttributes.addFlashAttribute("invalidUpdatedEducation", true);
			redirectAttributes.addFlashAttribute("uEducationForm", uEducationForm);
			redirectAttributes.addFlashAttribute(UserDashboardController.BINDING_RESULT_UPDATED_EDUCATION, bindingResult);
		}
		
		setModelAttributesForViewingUserDashboard(model);
		return "redirect:/" + WebConstants.Pages.USER_PROFILE_OVERVIEW;
	}
	
	@RequestMapping(value = "/u/dashboard/{uEducationId}/deleteUEducation")
	public String deleteUEducation(HttpServletRequest request, HttpServletResponse response, 
			@PathVariable("uEducationId") int uEducationId, Model model) {
		uEducationService.delete(uEducationId);
		setModelAttributesForViewingUserDashboard(model);
		return "redirect:/" + WebConstants.Pages.USER_PROFILE_OVERVIEW;
	}
	
	/** UEmployment */
	
	@RequestMapping(value = "/u/dashboard/createUEmployment")
	public String createUEmployment(HttpServletRequest request, HttpServletResponse response,
					@Valid @ModelAttribute("uEmploymentForm") UEmploymentForm uEmploymentForm,
					BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model) {
		if(!bindingResult.hasErrors()) {
			User user = SecurityUtil.getCurrentUser();
			uEmploymentService.create(user, uEmploymentForm.getClientName(), uEmploymentForm.getPositionHeld(),
									uEmploymentForm.getStartDate(), uEmploymentForm.getEndDate(),
									uEmploymentForm.getDescription());
		} else {
			redirectAttributes.addFlashAttribute("invalidEmployment", true);
			redirectAttributes.addFlashAttribute("uEmploymentForm", uEmploymentForm);
			redirectAttributes.addFlashAttribute(UserDashboardController.BINDING_RESULT_ADDED_EMPLOYMENT, bindingResult);
		}
		
		setModelAttributesForViewingUserDashboard(model);
		return "redirect:/" + WebConstants.Pages.USER_PROFILE_OVERVIEW;
	}
	
	@RequestMapping(value = "/u/dashboard/{uEmploymentId}/updateUEmployment")
	public String updateUEmployemnt(HttpServletRequest request, HttpServletResponse response,
					@Valid @ModelAttribute("uEmploymentForm") UEmploymentForm uEmploymentForm,
					BindingResult bindingResult, @PathVariable("uEmploymentId") int uEmploymentId,
					RedirectAttributes redirectAttributes, Model model) {
		if(!bindingResult.hasErrors()) {
			uEmploymentService.update(uEmploymentId, uEmploymentForm.getClientName(), uEmploymentForm.getPositionHeld(),
									uEmploymentForm.getStartDate(), uEmploymentForm.getEndDate(),
									uEmploymentForm.getDescription());
		} else {
			redirectAttributes.addFlashAttribute("invalidUpdatedEmployment", true);
			redirectAttributes.addFlashAttribute("uEmploymentForm", uEmploymentForm);
			redirectAttributes.addFlashAttribute(UserDashboardController.BINDING_RESULT_UPDATED_EMPLOYMENT, bindingResult);
		}
		
		setModelAttributesForViewingUserDashboard(model);
		return "redirect:/" + WebConstants.Pages.USER_PROFILE_OVERVIEW;
	}
	
	@RequestMapping(value = "/u/dashboard/{uEmploymentId}/deleteUEmployment")
	public String deleteUEmployment(HttpServletRequest request, HttpServletResponse response,
					@PathVariable("uEmploymentId") int uEmploymentId, Model model) {
		uEmploymentService.delete(uEmploymentId);
		
		setModelAttributesForViewingUserDashboard(model);
		return "redirect:/" + WebConstants.Pages.USER_PROFILE_OVERVIEW;
	}
	
	/** ULicense */
	
	@RequestMapping(value = "/u/dashboard/createULicense")
	public String createULicense(HttpServletRequest request, HttpServletResponse response,
								@Valid @ModelAttribute("uLicenseForm") ULicenseForm uLicenseForm,
								BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
		if(!bindingResult.hasErrors()) {
			User user = SecurityUtil.getCurrentUser();
			uLicenseService.create(user, uLicenseForm.getConferringOrganization(), uLicenseForm.getProfessionalLicense(),
								uLicenseForm.getDateIssued(), uLicenseForm.getLicenseNumber(), uLicenseForm.getDescription());
		} else {
			redirectAttributes.addFlashAttribute("invalidAddedLicense", true);
			redirectAttributes.addFlashAttribute("uLicenseForm", uLicenseForm);
			redirectAttributes.addFlashAttribute(UserDashboardController.BINDING_RESULT_ADDED_LICENSE, bindingResult);
		}
		
		setModelAttributesForViewingUserDashboard(model);
		return "redirect:/" + WebConstants.Pages.USER_PROFILE_OVERVIEW;
	}
	
	@RequestMapping(value = "/u/dashboard/{uLicenseId}/updateULicense")
	public String updateULicense(HttpServletRequest request, HttpServletResponse response,
					@Valid @ModelAttribute("uLicenseForm") ULicenseForm uLicenseForm,
					BindingResult bindingResult, @PathVariable("uLicenseId") int uLicenseId,
					RedirectAttributes redirectAttributes, Model model) {
		if(!bindingResult.hasErrors()) {
			uLicenseService.update(uLicenseId, uLicenseForm.getConferringOrganization(), uLicenseForm.getProfessionalLicense(),
								uLicenseForm.getDateIssued(), uLicenseForm.getLicenseNumber(), uLicenseForm.getDescription());
		} else {
			redirectAttributes.addFlashAttribute("invalidUpdatedLicense", true);
			redirectAttributes.addFlashAttribute("uLicenseForm", uLicenseForm);
			redirectAttributes.addFlashAttribute(UserDashboardController.BINDING_RESULT_UPDATED_LICENSE, bindingResult);
		}
		
		setModelAttributesForViewingUserDashboard(model);
		return "redirect:/" + WebConstants.Pages.USER_PROFILE_OVERVIEW;
	}
	
	@RequestMapping(value = "/u/dashboard/{uLicenseId}/deleteULicense")
	public String deleteULicense(HttpServletRequest request, HttpServletResponse response,
					@PathVariable("uLicenseId") int uLicenseId, Model model) {
		uLicenseService.delete(uLicenseId);
		
		setModelAttributesForViewingUserDashboard(model);
		return "redirect:/" + WebConstants.Pages.USER_PROFILE_OVERVIEW;
	}
	
	private void setModelAttributesForViewingUserDashboard(Model model) {
		User jvUser = SecurityUtil.getCurrentUser();
		
		Profile profile = profileService.findOneByUserId(jvUser.getUserId());
		model.addAttribute("profile", profile);
		
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
