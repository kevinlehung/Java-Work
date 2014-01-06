package vn.jv.web.bean;

import vn.jv.db.entity.AcAction;
import vn.jv.db.entity.AcResource;

public class RoleResourceBean {

	private int acPermissionId;
	private AcResource acResource;
	private AcAction acAction;
	
	/**
	 * @return the acPermissionId
	 */
	public int getAcPermissionId() {
		return acPermissionId;
	}

	/**
	 * @param acPermissionId the acPermissionId to set
	 */
	public void setAcPermissionId(int acPermissionId) {
		this.acPermissionId = acPermissionId;
	}

	/**
	 * @return the acResource
	 */
	public AcResource getAcResource() {
		return acResource;
	}

	/**
	 * @param acResource the acResource to set
	 */
	public void setAcResource(AcResource acResource) {
		this.acResource = acResource;
	}

	/**
	 * @return the acAction
	 */
	public AcAction getAcAction() {
		return acAction;
	}

	/**
	 * @param acAction the acAction to set
	 */
	public void setAcAction(AcAction acAction) {
		this.acAction = acAction;
	}
}
