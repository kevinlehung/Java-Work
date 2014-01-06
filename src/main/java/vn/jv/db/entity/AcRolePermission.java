package vn.jv.db.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the ac_role_permission database table.
 * 
 */
@Entity
@Table(name="ac_role_permission")
public class AcRolePermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AC_ROLE_PERMISSION_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int acRolePermissionId;

	@Column(name="DATE_CREATED")
	private Timestamp dateCreated;

	@Column(name="DESCRIPTION")
	private String description;

	//bi-directional many-to-one association to AcPermission
    @ManyToOne
	@JoinColumn(name="AC_PERMISSION_ID")
	private AcPermission acPermission;

	//bi-directional many-to-one association to AcRole
    @ManyToOne
	@JoinColumn(name="AC_ROLE_ID")
	private AcRole acRole;

    public AcRolePermission() {
    }

	public int getAcRolePermissionId() {
		return this.acRolePermissionId;
	}

	public void setAcRolePermissionId(int acRolePermissionId) {
		this.acRolePermissionId = acRolePermissionId;
	}

	public Timestamp getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AcPermission getAcPermission() {
		return this.acPermission;
	}

	public void setAcPermission(AcPermission acPermission) {
		this.acPermission = acPermission;
	}
	
	public AcRole getAcRole() {
		return this.acRole;
	}

	public void setAcRole(AcRole acRole) {
		this.acRole = acRole;
	}
	
}