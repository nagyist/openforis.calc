/**
 * This class is generated by jOOQ
 */
package org.openforis.calc.persistence.jooq.tables.pojos;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.1" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CategoryBase implements java.io.Serializable {

	private static final long serialVersionUID = -2141405579;

	private java.lang.Integer id;
	private java.lang.Integer originalId;
	private java.lang.String  caption;
	private java.lang.String  description;
	private java.lang.Long    workspaceId;
	private java.lang.String  name;

	public CategoryBase() {}

	public CategoryBase(
		java.lang.Integer id,
		java.lang.Integer originalId,
		java.lang.String  caption,
		java.lang.String  description,
		java.lang.Long    workspaceId,
		java.lang.String  name
	) {
		this.id = id;
		this.originalId = originalId;
		this.caption = caption;
		this.description = description;
		this.workspaceId = workspaceId;
		this.name = name;
	}

	public java.lang.Integer getId() {
		return this.id;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getOriginalId() {
		return this.originalId;
	}

	public void setOriginalId(java.lang.Integer originalId) {
		this.originalId = originalId;
	}

	public java.lang.String getCaption() {
		return this.caption;
	}

	public void setCaption(java.lang.String caption) {
		this.caption = caption;
	}

	public java.lang.String getDescription() {
		return this.description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}

	public java.lang.Long getWorkspaceId() {
		return this.workspaceId;
	}

	public void setWorkspaceId(java.lang.Long workspaceId) {
		this.workspaceId = workspaceId;
	}

	public java.lang.String getName() {
		return this.name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}
}
