package vn.jv.db.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ac_resource database table.
 * 
 */
@Entity
@Table(name="ac_resource")
public class AcResource implements Serializable {
	
	public static final String VIEW_CLIENT_NAME = "View Client Name";
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AC_RESOURCE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer acResourceId;

	@Column(name="DATE_CREATED")
	private Timestamp dateCreated;

	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="RESOURCE_NAME")
	private String resourceName;

	@Column(name="RESOURCE_IDENTIFIER")
	private String resourceIdentifier;

	//bi-directional many-to-one association to AcPermission
	@OneToMany(mappedBy="acResource")
	private List<AcPermission> acPermissions;

    public AcResource() {
    }

	public Integer getAcResourceId() {
		return this.acResourceId;
	}

	public void setAcResourceId(Integer acResourceId) {
		this.acResourceId = acResourceId;
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

	public String getResourceName() {
		return this.resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public List<AcPermission> getAcPermissions() {
		return this.acPermissions;
	}

	public void setAcPermissions(List<AcPermission> acPermissions) {
		this.acPermissions = acPermissions;
	}

	public void setResourceIdentifier(String resourceIdentifier) {
		this.resourceIdentifier = resourceIdentifier;
	}

	public String getResourceIdentifier() {
		return resourceIdentifier;
	}
	
}