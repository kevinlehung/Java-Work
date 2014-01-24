package vn.jv.persist.domain;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the ac_role_hierarchy database table.
 * 
 */
@Entity
@Table(name="ac_role_hierarchy")
public class AcRoleHierarchy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AC_ROLE_HIERARCHY_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int acRoleHierarchyId;

	@Column(name="DATE_CREATED")
	private Timestamp dateCreated;

	//bi-directional many-to-one association to AcRole
    @ManyToOne
	@JoinColumn(name="AC_ROLE_ID")
	private AcRole acRole;

	//bi-directional many-to-one association to AcRole
    @ManyToOne
	@JoinColumn(name="PARENT_AC_ROLE_ID")
	private AcRole parentAcRole;

    public AcRoleHierarchy() {
    }

	public int getAcRoleHierarchyId() {
		return this.acRoleHierarchyId;
	}

	public void setAcRoleHierarchyId(int acRoleHierarchyId) {
		this.acRoleHierarchyId = acRoleHierarchyId;
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
	
	public AcRole getParentAcRole() {
		return this.parentAcRole;
	}

	public void setParentAcRole(AcRole parentAcRole) {
		this.parentAcRole = parentAcRole;
	}
	
}