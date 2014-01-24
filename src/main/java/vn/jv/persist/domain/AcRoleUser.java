package vn.jv.persist.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.AccessType;

import java.sql.Timestamp;


/**
 * The persistent class for the ac_role_user database table.
 * 
 */
@Entity
@Table(name="ac_role_user")
public class AcRoleUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AC_ROLE_USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@AccessType("property")
	private int acRoleUserId;

	@Column(name="DATE_CREATED")
	private Timestamp dateCreated;

	//bi-directional many-to-one association to AcRole
    @ManyToOne
	@JoinColumn(name="AC_ROLE_ID")
	private AcRole acRole;

	//bi-directional many-to-one association to User
    @ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;

    public AcRoleUser() {
    }

	public int getAcRoleUserId() {
		return this.acRoleUserId;
	}

	public void setAcRoleUserId(int acRoleUserId) {
		this.acRoleUserId = acRoleUserId;
	}

	public Timestamp getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public AcRole getAcRole() {
		return this.acRole;
	}

	public void setAcRole(AcRole acRole) {
		this.acRole = acRole;
	}
	
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}