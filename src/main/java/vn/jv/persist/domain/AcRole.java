package vn.jv.persist.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


/**
 * The persistent class for the ac_role database table.
 * 
 */
@Entity
@Table(name="ac_role")
@XmlRootElement(name = "Loan")
@XmlType(propOrder={"acRoleId", "roleName", "description", "dateCreated", "active"})
public class AcRole implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String AUTO_INDEX_ROLE_NAME = "Auto Index";
	public static final String AUTO_INDEX_STATS_ROLE_NAME = "Auto Index Stats";

	@Id
	@Column(name="AC_ROLE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int acRoleId;

	@Column(name="DATE_CREATED")
	private Timestamp dateCreated;

	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="ROLE_NAME")
	private String roleName;
	
	@Column(name="ACTIVE")
	private boolean active;
	
	@OneToMany(mappedBy = "acRole", cascade = CascadeType.ALL)  
	private List<AcRolePermission> acRolePermissions;
	
	@OneToMany(mappedBy = "acRole", cascade = CascadeType.ALL)  
	private List<RoleMenuItem> roleMenuItems;
	
    public AcRole() {
    }
    public AcRole(int acRoleId){
    	setAcRoleId(acRoleId);
    }
	@XmlElement(name = "RoleId")
	public int getAcRoleId() {
		return this.acRoleId;
	}

	public void setAcRoleId(int acRoleId) {
		this.acRoleId = acRoleId;
	}

	@XmlElement(name = "DateCreated")
	public Timestamp getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	@XmlElement(name = "Description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement(name = "RoleName")
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	@XmlElement(name = "Active")
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@XmlTransient
	public List<AcRolePermission> getAcRolePermissions() {
		return acRolePermissions;
	}

	public void setAcRolePermissions(List<AcRolePermission> acRolePermissions) {
		this.acRolePermissions = acRolePermissions;
	}

	@XmlTransient
	public List<RoleMenuItem> getRoleMenuItems() {
		return roleMenuItems;
	}

	public void setRoleMenuItems(List<RoleMenuItem> roleMenuItems) {
		this.roleMenuItems = roleMenuItems;
	}
}