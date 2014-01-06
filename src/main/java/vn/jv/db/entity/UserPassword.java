package vn.jv.db.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the user_password database table.
 * 
 */
@Entity
@Table(name="user_password")
public class UserPassword implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_PASSWORD_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userPasswordId;

	@Column(name="DATE_CREATED")
	private Timestamp dateCreated;
	
	@Column(name="USER_PASSWORD")
	private String userPassword;

	//bi-directional many-to-one association to User
    @ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;

    public UserPassword() {
    }

	public Timestamp getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getUserPasswordId() {
		return userPasswordId;
	}

	public void setUserPasswordId(int userPasswordId) {
		this.userPasswordId = userPasswordId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}