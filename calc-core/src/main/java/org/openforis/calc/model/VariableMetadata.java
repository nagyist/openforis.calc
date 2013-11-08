package org.openforis.calc.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 
 * @author G. Miceli
 * @author M. Togna
 * 
 */
public class VariableMetadata extends Variable {

	private static final long serialVersionUID = 1L;
	
	private Variable variable;
	private Map<String, Category> categoriesByCode;
	private ObservationUnitMetadata observationUnitMetadata;
	
	public VariableMetadata(Variable variable) {
		this.variable = variable;
	}

	public VariableMetadata(Variable variable, Collection<Category> categories) {
		this.variable = variable;
		setCategories(categories);
	}

	private void setCategories(Collection<Category> categories) {
		categoriesByCode = new HashMap<String, Category>();
		for ( Category category : categories ) {
			String code = category.getCategoryCode();
			categoriesByCode.put(code, category);
		}
	}

	public Collection<Category> getCategories() {
		return Collections.unmodifiableCollection(categoriesByCode.values());
	}

	public Category getCategoryByCode(String code) {
		return categoriesByCode.get(code);
	}

	public String getVariableName() {
		return variable.getVariableName();
	}

	public Integer getVariableId() {
		return variable.getId();
	}

	public boolean isCategorical() {
		return variable.isCategorical();
	}

	public boolean isNumeric() {
		return variable.isNumeric();
	}

	public Integer getObsUnitId() {
		return variable.getObsUnitId();
	}

	public Integer getVariableOrder() {
		return variable.getVariableOrder();
	}

	public String getVariableLabel() {
		return variable.getVariableLabel();
	}

	public String getVariableDescription() {
		return variable.getVariableDescription();
	}

	public boolean isForAnalysis() {
		return variable.getForAnalysis();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append(variable.getVariableName()).toString();
	}

	void setObservationUnitMetadata(ObservationUnitMetadata observationUnitMetadata) {
		this.observationUnitMetadata = observationUnitMetadata;
	}
	
	public ObservationUnitMetadata getObservationUnitMetadata() {
		return observationUnitMetadata;
	}

	public Integer getId() {
		return variable.getId();
	}

	public int hashCode() {
		return variable.hashCode();
	}

	public Boolean getForAnalysis() {
		return variable.getForAnalysis();
	}

	public boolean equals(Object obj) {
		return variable.equals(obj);
	}

	public String getDimensionTableName() {
		return getVariableName();
	}

	public VariableType getVariableTypeEnum() {
		return variable.getVariableTypeEnum();
	}

	public String getUom() {
		return variable.getUom();
	}

	public Unit<? extends Quantity> getUnit() {
		return variable.getUnit();
	}
}