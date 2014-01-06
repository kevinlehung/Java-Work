package vn.jv.db.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.AccessType;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity(name="vn.jv.db.entity.User")
@Table(name="user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@AccessType("property")
	private int userId;

	@Column(name="ACCOUNT_LOCKED")
	private Boolean accountLocked;

	@Column(name="DATE_CREATED")
	private Timestamp dateCreated;

	@Column(name="DATE_UPDATED")
	private Timestamp dateUpdated;

	@Column(name="FAILED_LOGIN_ATTEMPTS")
	private int failedLoginAttempts;
	
	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_FAILED_LOGIN_DATE")
	private Timestamp lastFailedLoginDate;

	@Column(name="LAST_LOGIN_DATE")
	private Timestamp lastLoginDate;
	
	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="PASSWORD_EXPIRED")
	private Boolean passwordExpired;
	
	@Column(name="PASSWORD_LAST_CHANGED_DATE")
	private Date passwordLastChangedDate;

	@Column(name="USER_EMAIL")
	private String userEmail;

	@Column(name="USER_NAME")
	private String userName;

	@Column(name="USER_PASSWORD")
	private String userPassword;
	@Column(name="ACTIVE")
	private Boolean userActive;
	
	@Column(name="API_LOGIN")
	private Boolean apiLogin = Boolean.FALSE;
	
	@Column(name="PASSWORD_HASH")
	private String passwordHash;
	
	@Column(name="PASSWORD_HASH_DATE")
	private Date passwordHashDate;

	@Transient
	private Integer vendor;
	@Transient 
	private String[] lstRoles;
	@Transient
	private String status;
	@Transient 
	private String vendorName;
	@Transient 
	private String lstRolesAssigned;
	//bi-directional many-to-one association to AcRoleUser
	@OneToMany(mappedBy="user")
	private List<AcRoleUser> acRoleUsers;

	//bi-directional many-to-one association to UserLogin
	@OneToMany(mappedBy="user")
	private List<UserLogin> userLogins;
	
    public Boolean getAccountLocked() {
		return accountLocked;
	}

	public void setAccountLocked(Boolean accountLocked) {
		this.accountLocked = accountLocked;
	}

	public int getFailedLoginAttempts() {
		return failedLoginAttempts;
	}

	public void setFailedLoginAttempts(int failedLoginAttempts) {
		this.failedLoginAttempts = failedLoginAttempts;
	}

	public Timestamp getLastFailedLoginDate() {
		return lastFailedLoginDate;
	}

	public void setLastFailedLoginDate(Timestamp lastFailedLoginDate) {
		this.lastFailedLoginDate = lastFailedLoginDate;
	}

	public Timestamp getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public User() {
    }

	public User(int userId) {
		setUserId(userId);
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Timestamp getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Timestamp getDateUpdated() {
		return this.dateUpdated;
	}

	public void setDateUpdated(Timestamp dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getPasswordLastChangedDate() {
		return passwordLastChangedDate;
	}

	public void setPasswordLastChangedDate(Date passwordLastChangedDate) {
		this.passwordLastChangedDate = passwordLastChangedDate;
	}

	public Boolean getPasswordExpired() {
		return passwordExpired;
	}

	public void setPasswordExpired(Boolean passwordExpired) {
		this.passwordExpired = passwordExpired;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public List<AcRoleUser> getAcRoleUsers() {
		return this.acRoleUsers;
	}

	public void setAcRoleUsers(List<AcRoleUser> acRoleUsers) {
		this.acRoleUsers = acRoleUsers;
	}

	public void setUserLogins(List<UserLogin> userLogins) {
		this.userLogins = userLogins;
	}

	public List<UserLogin> getUserLogins() {
		return userLogins;
	}

	public  void setVendor(Integer vendor) {
		this.vendor = vendor;
	}

	public Integer getVendor() {
		return vendor;
	}

	public void setLstRoles(String[] lstRoles) {
		this.lstRoles = lstRoles;
	}

	public String[] getLstRoles() {
		return lstRoles;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setUserActive(Boolean userActive) {
		this.userActive = userActive;
	}

	public Boolean getUserActive() {
		return userActive;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setLstRolesAssigned(String lstRolesAssigned) {
		this.lstRolesAssigned = lstRolesAssigned;
	}

	public String getLstRolesAssigned() {
		return lstRolesAssigned;
	}

	public Boolean getApiLogin() {
		return apiLogin;
	}

	public void setApiLogin(Boolean apiLogin) {
		this.apiLogin = apiLogin;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public Date getPasswordHashDate() {
		return passwordHashDate;
	}

	public void setPasswordHashDate(Date passwordHashDate) {
		this.passwordHashDate = passwordHashDate;
	}
}