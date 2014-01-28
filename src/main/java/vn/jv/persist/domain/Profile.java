package vn.jv.persist.domain;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.AccessType;


/**
 * The persistent class for the profile database table.
 * 
 */
@Entity
@NamedQuery(name="Profile.findAll", query="SELECT p FROM Profile p")
public class Profile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PROFILE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@AccessType("property")
	private int profileId;

	private String experience;

	@Column(name="HOURLY_RATE")
	private int hourlyRate;

	private String overview;

	@Column(name="PHOTO_ATTACH_FILE_ID")
	private int photoAttachFileId;

	private String tagline;

	public Profile() {
	}

	public int getProfileId() {
		return this.profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public String getExperience() {
		return this.experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public int getHourlyRate() {
		return this.hourlyRate;
	}

	public void setHourlyRate(int hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public String getOverview() {
		return this.overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public int getPhotoAttachFileId() {
		return this.photoAttachFileId;
	}

	public void setPhotoAttachFileId(int photoAttachFileId) {
		this.photoAttachFileId = photoAttachFileId;
	}

	public String getTagline() {
		return this.tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

}