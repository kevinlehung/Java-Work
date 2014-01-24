package vn.jv.persist.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the user_login database table.
 * 
 */
@Entity
@Table(name="user_login")
public class UserLogin implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final boolean LOGIN_FAILED = false;
	public static final boolean LOGIN_SUCCESS = true;
	public static final boolean CONFIGURED_SYSLOG = Boolean.TRUE;
	public static final boolean NOT_CONFIGURED_SYSLOG = Boolean.FALSE;
	public static final String TYPE_LOGIN = "LOGIN";
	public static final String TYPE_LOGOUT = "LOGOUT";

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_LOGIN_ID")
	private int userLoginId;

	@Column(name="IP")
	private String ip;

	@Column(name="LOGIN_TIME")
	private Timestamp loginTime;

	@Column(name="STATUS")
	private Boolean status;

	@Column(name="SYS_LOG")
	private Boolean sysLog;

	@Column(name="TIME_ZONE")
	private String timeZone;

	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="TYPE")
	private String type;

	//bi-directional many-to-one association to User
    @ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;

    public UserLogin() {
    }

	public int getUserLoginId() {
		return this.userLoginId;
	}

	public void setUserLoginId(int userLoginId) {
		this.userLoginId = userLoginId;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Timestamp getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Boolean getSysLog() {
		return this.sysLog;
	}

	public void setSysLog(Boolean sysLog) {
		this.sysLog = sysLog;
	}

	public String getTimeZone() {
		return this.timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}