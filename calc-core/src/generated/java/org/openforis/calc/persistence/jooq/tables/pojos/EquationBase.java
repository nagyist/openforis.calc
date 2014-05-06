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
public class EquationBase implements java.io.Serializable {

	private static final long serialVersionUID = -1432586287;

	private java.lang.Long   id;
	private java.lang.Long   listId;
	private java.lang.String code;
	private java.lang.String equation;
	private java.lang.String condition;

	public EquationBase() {}

	public EquationBase(
		java.lang.Long   id,
		java.lang.Long   listId,
		java.lang.String code,
		java.lang.String equation,
		java.lang.String condition
	) {
		this.id = id;
		this.listId = listId;
		this.code = code;
		this.equation = equation;
		this.condition = condition;
	}

	public java.lang.Long getId() {
		return this.id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getListId() {
		return this.listId;
	}

	public void setListId(java.lang.Long listId) {
		this.listId = listId;
	}

	public java.lang.String getCode() {
		return this.code;
	}

	public void setCode(java.lang.String code) {
		this.code = code;
	}

	public java.lang.String getEquation() {
		return this.equation;
	}

	public void setEquation(java.lang.String equation) {
		this.equation = equation;
	}

	public java.lang.String getCondition() {
		return this.condition;
	}

	public void setCondition(java.lang.String condition) {
		this.condition = condition;
	}
}
