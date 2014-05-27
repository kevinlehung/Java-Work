package vn.jv.web.form;

import java.util.Date;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Model attribute for updating UEmployment actions
 *
 * @author tthieucdl@gmail.com
 *
 */
public class UEmploymentForm {
	
	private int uEmploymentId;
	
	@NotBlank(message = "Client Name is required")
	@Size(min = 2, max = 512, message = "Length of Client Name must be from 2 to 512 characters")
	private String clientName;

	@NotBlank(message = "Position Held is required")
	@Size(min = 2, max = 512, message = "Length of Position Held must be from 2 to 512 characters")
	private String positionHeld;
	
	@NotNull(message = "Start Date is required")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date startDate;
	
	@NotNull(message = "End Date is required")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date endDate;
	
	@Size(max = 1024,  message = "Length of Description must be less than 1024")
	private String description;
	
	private int userId;

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getPositionHeld() {
		return positionHeld;
	}

	public void setPositionHeld(String positionHeld) {
		this.positionHeld = positionHeld;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getuEmploymentId() {
		return uEmploymentId;
	}

	public void setuEmploymentId(int uEmploymentId) {
		this.uEmploymentId = uEmploymentId;
	}
}
