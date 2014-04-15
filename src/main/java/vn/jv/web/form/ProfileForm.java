package vn.jv.web.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Model Attribute for updating Profile actions
 *
 * @author tthieucdl@gmail.com
 *
 */
public class ProfileForm {
	
	@NotBlank(message="Tagline is required")
	@Size(min = 3, max = 128, message = "Length of Tagline must be from 3 to 128 characters")
	private String tagline;
	
	@NotBlank(message="Overview is required")
	@Size(min = 3, max = 1024, message = "Length of Overview must be from 3 to 1024 characters")
	private String overview;
	
	private int hourlyRate;
	
	@NotBlank(message="Experience is required")
	@Size(min = 3, max = 1024, message = "Length of Experience must be from 3 to 1024 characters")
	private String experience;
	
	@Size(max = 1024, message = "Length of Service Description must be from 3 to 1024 characters")
	private String serviceDescription;
	
	private int photoAttachFileId;
	
	private int userId;

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public int getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(int hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public int getPhotoAttachFileId() {
		return photoAttachFileId;
	}

	public void setPhotoAttachFileId(int photoAttachFileId) {
		this.photoAttachFileId = photoAttachFileId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
