package org.openforis.calc.model;
// Generated Aug 8, 2012 5:42:26 PM by Hibernate Tools 3.4.0.CR1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * SubstratumPlotCount generated by hbm2java
 */
@Entity
@Table(name="substratum_plot_count"
)
public class SubstratumPlotCount  implements java.io.Serializable {


     private SubstratumPlotCountId id;

    public SubstratumPlotCount() {
    }

    public SubstratumPlotCount(SubstratumPlotCountId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="stratumId", column=@Column(name="stratum_id") ), 
        @AttributeOverride(name="adminUnitId", column=@Column(name="admin_unit_id") ), 
        @AttributeOverride(name="count", column=@Column(name="count") ) } )
    public SubstratumPlotCountId getId() {
        return this.id;
    }
    
    public void setId(SubstratumPlotCountId id) {
        this.id = id;
    }




}


