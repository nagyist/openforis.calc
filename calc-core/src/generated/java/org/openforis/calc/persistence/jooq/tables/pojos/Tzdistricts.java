/**
 * This class is generated by jOOQ
 */
package org.openforis.calc.persistence.jooq.tables.pojos;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "2.6.0"},
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings("all")
public class Tzdistricts implements java.io.Serializable {

	private static final long serialVersionUID = -1016740208;

	private java.lang.Integer    gid;
	private java.lang.Long       cat;
	private java.lang.Long       dn;
	private java.lang.Long       distId;
	private java.lang.String     distName;
	private java.lang.String     regName;
	private java.math.BigDecimal landProp;
	private java.math.BigDecimal totalArea;
	private java.lang.Object     geom;

	public java.lang.Integer getGid() {
		return this.gid;
	}

	public void setGid(java.lang.Integer gid) {
		this.gid = gid;
	}

	public java.lang.Long getCat() {
		return this.cat;
	}

	public void setCat(java.lang.Long cat) {
		this.cat = cat;
	}

	public java.lang.Long getDn() {
		return this.dn;
	}

	public void setDn(java.lang.Long dn) {
		this.dn = dn;
	}

	public java.lang.Long getDistId() {
		return this.distId;
	}

	public void setDistId(java.lang.Long distId) {
		this.distId = distId;
	}

	public java.lang.String getDistName() {
		return this.distName;
	}

	public void setDistName(java.lang.String distName) {
		this.distName = distName;
	}

	public java.lang.String getRegName() {
		return this.regName;
	}

	public void setRegName(java.lang.String regName) {
		this.regName = regName;
	}

	public java.math.BigDecimal getLandProp() {
		return this.landProp;
	}

	public void setLandProp(java.math.BigDecimal landProp) {
		this.landProp = landProp;
	}

	public java.math.BigDecimal getTotalArea() {
		return this.totalArea;
	}

	public void setTotalArea(java.math.BigDecimal totalArea) {
		this.totalArea = totalArea;
	}

	public java.lang.Object getGeom() {
		return this.geom;
	}

	public void setGeom(java.lang.Object geom) {
		this.geom = geom;
	}
}