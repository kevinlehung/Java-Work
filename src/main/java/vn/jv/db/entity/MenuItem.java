package vn.jv.db.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



/**
 * The persistent class for the menu_item database table.
 * 
 */
@Entity
@Table(name="menu_item")
public class MenuItem implements Serializable {
	
	public static final String LOGOUT_MENU_NAME = "LogoutMenu";
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MENU_ITEM_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer menuItemId;

	@ManyToOne
	@JoinColumn(name="PARENT_ID")
	private MenuItem parentMenuItem;

	@Column(name="NAME")
	private String name;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="LOCATION")
	private String location;
	
	@Column(name="IMAGE")
	private String image;
	
	@Column(name="IMAGE_FOCUS")
	private String imageFocus;
	
	@Column(name="SORT_ORDER")
	private Integer order;
	
	@OneToMany(mappedBy = "menuItem", cascade = CascadeType.ALL)  
	private List<RoleMenuItem> roleMenuItems;
	
    public MenuItem() {
    }

	public Integer getMenuItemId() {
		return menuItemId;
	}

	public void setMenuItemId(Integer menuItemId) {
		this.menuItemId = menuItemId;
	}

	public MenuItem getParentMenuItem() {
		return parentMenuItem;
	}

	public void setParentMenuItem(MenuItem parentMenuItem) {
		this.parentMenuItem = parentMenuItem;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImageFocus() {
		return imageFocus;
	}

	public void setImageFocus(String imageFocus) {
		this.imageFocus = imageFocus;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public List<RoleMenuItem> getRoleMenuItems() {
		return roleMenuItems;
	}

	public void setRoleMenuItems(List<RoleMenuItem> roleMenuItems) {
		this.roleMenuItems = roleMenuItems;
	}
}