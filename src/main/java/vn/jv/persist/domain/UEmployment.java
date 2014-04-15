package vn.jv.persist.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * The persistent class for the u_employment table.
 * 
 */
@Entity
@Table(name = "u_employment")
public class UEmployment implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "EMPLOYMENT_ID")
	private Integer employmentId;

	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;

	@Column(name = "CLIENT_NAME")
	private String clientName;

	@Column(name = "POSITION_HELD")
	private String positionHeld;

	@Column(name = "START_DATE")
	@DateTimeFormat(pattern = vn.jv.constant.WebConstants.FixValue.DEFAULT_DATE_FORMAT)
	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Column(name = "END_DATE")
	@DateTimeFormat(pattern = vn.jv.constant.WebConstants.FixValue.DEFAULT_DATE_FORMAT)
	@Temporal(TemporalType.DATE)
	private Date endDate;

	@Column(name = "DESCRIPTION")
	private String description;

	public UEmployment() {
	}

	public UEmployment(User user, String clientName, String positionHeld,
			Date startDate, Date endDate) {
		this.user = user;
		this.clientName = clientName;
		this.positionHeld = positionHeld;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public UEmployment(User user, String clientName, String positionHeld,
			Date startDate, Date endDate, String description) {
		this.user = user;
		this.clientName = clientName;
		this.positionHeld = positionHeld;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
	}

	public Integer getEmploymentId() {
		return this.employmentId;
	}

	public void setEmploymentId(Integer employmentId) {
		this.employmentId = employmentId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getPositionHeld() {
		return this.positionHeld;
	}

	public void setPositionHeld(String positionHeld) {
		this.positionHeld = positionHeld;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
