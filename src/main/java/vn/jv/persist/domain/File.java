package vn.jv.persist.domain;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.AccessType;

import java.util.Date;


/**
 * The persistent class for the file database table.
 * 
 */
@Entity
@NamedQuery(name="File.findAll", query="SELECT f FROM File f")
public class File implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FILE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@AccessType("property")
	private int fileId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_DATE")
	private Date createdDate;

	private String description;

	@Column(name="FILE_NAME")
	private String fileName;

	private String path;

	public File() {
	}

	public int getFileId() {
		return this.fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}