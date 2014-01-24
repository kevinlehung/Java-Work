package vn.jv.persist.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the ac_permission database table.
 * 
 */
@Entity
@Table(name="ac_permission")
public class AcPermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AC_PERMISSION_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int acPermissionId;

	@Column(name="DATE_CREATED")
	private Timestamp dateCreated;

	@Column(name="DESCRIPTION")
	private String description;

	//bi-directional many-to-one association to AcAction
    @ManyToOne
	@JoinColumn(name="AC_ACTION_ID")
	private AcAction acAction;

	//bi-directional many-to-one association to AcResource
    @ManyToOne
	@JoinColumn(name="AC_RESOURCE_ID")
	private AcResource acResource;
    
    public AcPermission() {
    }

	public int getAcPermissionId() {
		return this.acPermissionId;
	}

	public void setAcPermissionId(int acPermissionId) {
		this.acPermissionId = acPermissionId;
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

	public AcAction getAcAction() {
		return this.acAction;
	}

	public void setAcAction(AcAction acAction) {
		this.acAction = acAction;
	}
	
	public AcResource getAcResource() {
		return this.acResource;
	}

	public void setAcResource(AcResource acResource) {
		this.acResource = acResource;
	}
}