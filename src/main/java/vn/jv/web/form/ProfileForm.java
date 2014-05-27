package vn.jv.web.form;

/**
 * Model Attribute for updating Profile actions
 *
 * @author tthieucdl@gmail.com
 *
 */
public class ProfileForm {
	
	private int profileId;
	
	/**
	 * Additional Field, Not save on DB, when it is true, just check valid for Overview and ServiceDescription 
	 */
	private boolean isSimpleCheck;
	
	private String tagline;
	
	private String overview;
	
	private int hourlyRate;
	
	private String experience;
	
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

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public boolean isSimpleCheck() {
		return isSimpleCheck;
	}

	public void setSimpleCheck(boolean isSimpleCheck) {
		this.isSimpleCheck = isSimpleCheck;
	}

}
