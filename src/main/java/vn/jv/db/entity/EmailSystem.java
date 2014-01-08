package vn.jv.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the email_system database table.
 * 
 */
@Entity
@Table(name="email_system")
public class EmailSystem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EMAIL_SYSTEM_ID")
	private int emailSystemId;

	@Column(name="ACTIVE")
	private String active;

	@Column(name="DATE_CREATED")
	private Timestamp dateCreated;

	@Column(name="IS_DEFAULT")
	private boolean isDefault;

	@Column(name="PROTOCOL")
	private String protocol;

	@Column(name="USER_NAME")
	private String userName;

	@Column(name="PASSWORD")
	private String password;

	@Column(name="HOST")
	private String host;

	@Column(name="PORT")
	private int port;
	
	@Column(name="SENDER_EMAIL")
	private String senderEmail;

    public EmailSystem() {
    }

	public int getEmailSystemId() {
		return emailSystemId;
	}

	public void setEmailSystemId(int emailSystemId) {
		this.emailSystemId = emailSystemId;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

}