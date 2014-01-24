package vn.jv.persist.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the ac_action database table.
 * 
 */
@Entity
@Table(name="ac_action")
public class AcAction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AC_ACTION_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int acActionId;

	@Column(name="ACTION_NAME")
	private String actionName;

	@Column(name="DATE_CREATED")
	private Timestamp dateCreated;

	@Column(name="DESCRIPTION")
	private String description;

    public AcAction() {
    }

	public int getAcActionId() {
		return this.acActionId;
	}

	public void setAcActionId(int acActionId) {
		this.acActionId = acActionId;
	}

	public String getActionName() {
		return this.actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
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
}