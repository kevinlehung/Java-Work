package vn.jv.persist.domain;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.AccessType;

import java.util.Date;


/**
 * The persistent class for the job_apply database table.
 * 
 */
@Entity
@Table(name="job_apply")
@NamedQuery(name="JobApply.findAll", query="SELECT j FROM JobApply j")
public class JobApply implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="JOB_APPLY_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@AccessType("property")	
	private int jobApplyId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="APPLY_DATE")
	private Date applyDate;

	@Column(name="APPLY_USER_ID")
	private int applyUserId;

	@Column(name="BID_VALUE")
	private int bidValue;

	@Column(name="JOB_ID")
	private int jobId;

	private String proposal;

	private String status;

	public JobApply() {
	}

	public int getJobApplyId() {
		return this.jobApplyId;
	}

	public void setJobApplyId(int jobApplyId) {
		this.jobApplyId = jobApplyId;
	}

	public Date getApplyDate() {
		return this.applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public int getApplyUserId() {
		return this.applyUserId;
	}

	public void setApplyUserId(int applyUserId) {
		this.applyUserId = applyUserId;
	}

	public int getBidValue() {
		return this.bidValue;
	}

	public void setBidValue(int bidValue) {
		this.bidValue = bidValue;
	}

	public int getJobId() {
		return this.jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getProposal() {
		return this.proposal;
	}

	public void setProposal(String proposal) {
		this.proposal = proposal;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}