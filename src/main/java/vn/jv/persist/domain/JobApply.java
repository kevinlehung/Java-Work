package vn.jv.persist.domain;

import java.io.Serializable;
import javax.persistence.*;
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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="JOB_APPLY_ID")
	private int jobApplyId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="APPLY_DATE")
	private Date applyDate;

	@Column(name="BID_VALUE")
	private int bidValue;

	private String proposal;

	private String status;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="APPLY_USER_ID")
	private User appyUser;

	//bi-directional many-to-one association to Job
	@ManyToOne
	@JoinColumn(name="JOB_ID")
	private Job job;

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

	public int getBidValue() {
		return this.bidValue;
	}

	public void setBidValue(int bidValue) {
		this.bidValue = bidValue;
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

	public User getApplyUser() {
		return this.appyUser;
	}

	public void setApplyUser(User applyUser) {
		this.appyUser = applyUser;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

}