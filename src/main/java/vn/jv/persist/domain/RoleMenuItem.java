package vn.jv.persist.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the role_menu_item database table.
 * 
 */
@Entity
@Table(name="role_menu_item")
public class RoleMenuItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ROLE_MENU_ITEM_ID")
	private int roleMenuItemId;

	//bi-directional many-to-one association to AcRole
    @ManyToOne
	@JoinColumn(name="AC_ROLE_ID")
	private AcRole acRole;

	//bi-directional many-to-one association to MenuItem
    @ManyToOne
	@JoinColumn(name="MENU_ITEM_ID")
	private MenuItem menuItem;

    public RoleMenuItem() {
    }

	public int getRoleMenuItemId() {
		return this.roleMenuItemId;
	}

	public void setRoleMenuItemId(int roleMenuItemId) {
		this.roleMenuItemId = roleMenuItemId;
	}

	public AcRole getAcRole() {
		return this.acRole;
	}

	public void setAcRole(AcRole acRole) {
		this.acRole = acRole;
	}
	
	public MenuItem getMenuItem() {
		return this.menuItem;
	}

	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}
	
}