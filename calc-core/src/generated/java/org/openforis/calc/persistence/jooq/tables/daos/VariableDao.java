/**
 * This class is generated by jOOQ
 */
package org.openforis.calc.persistence.jooq.tables.daos;

import org.openforis.calc.metadata.Variable;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.1" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class VariableDao extends org.jooq.impl.DAOImpl<org.openforis.calc.persistence.jooq.tables.records.VariableRecord, Variable, java.lang.Integer> {

	/**
	 * Create a new VariableDao without any configuration
	 */
	public VariableDao() {
		super(org.openforis.calc.persistence.jooq.tables.VariableTable.VARIABLE, Variable.class);
	}

	/**
	 * Create a new VariableDao with an attached configuration
	 */
	public VariableDao(org.jooq.Configuration configuration) {
		super(org.openforis.calc.persistence.jooq.tables.VariableTable.VARIABLE, Variable.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected java.lang.Integer getId(Variable object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public java.util.List<Variable> fetchById(java.lang.Integer... values) {
		return fetch(org.openforis.calc.persistence.jooq.tables.VariableTable.VARIABLE.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public Variable fetchOneById(java.lang.Integer value) {
		return fetchOne(org.openforis.calc.persistence.jooq.tables.VariableTable.VARIABLE.ID, value);
	}

	/**
	 * Fetch records that have <code>entity_id IN (values)</code>
	 */
	public java.util.List<Variable> fetchByEntityId(java.lang.Integer... values) {
		return fetch(org.openforis.calc.persistence.jooq.tables.VariableTable.VARIABLE.ENTITY_ID, values);
	}

	/**
	 * Fetch records that have <code>input_value_column IN (values)</code>
	 */
	public java.util.List<Variable> fetchByInputValueColumn(java.lang.String... values) {
		return fetch(org.openforis.calc.persistence.jooq.tables.VariableTable.VARIABLE.INPUT_VALUE_COLUMN, values);
	}

	/**
	 * Fetch records that have <code>scale IN (values)</code>
	 */
	public java.util.List<Variable> fetchByScale(org.openforis.calc.metadata.Variable.Scale... values) {
		return fetch(org.openforis.calc.persistence.jooq.tables.VariableTable.VARIABLE.SCALE, values);
	}

	/**
	 * Fetch records that have <code>name IN (values)</code>
	 */
	public java.util.List<Variable> fetchByName(java.lang.String... values) {
		return fetch(org.openforis.calc.persistence.jooq.tables.VariableTable.VARIABLE.NAME, values);
	}

	/**
	 * Fetch records that have <code>original_id IN (values)</code>
	 */
	public java.util.List<Variable> fetchByOriginalId(java.lang.Integer... values) {
		return fetch(org.openforis.calc.persistence.jooq.tables.VariableTable.VARIABLE.ORIGINAL_ID, values);
	}

	/**
	 * Fetch records that have <code>default_value IN (values)</code>
	 */
	public java.util.List<Variable> fetchByDefaultValue(java.lang.String... values) {
		return fetch(org.openforis.calc.persistence.jooq.tables.VariableTable.VARIABLE.DEFAULT_VALUE, values);
	}

	/**
	 * Fetch records that have <code>multiple_response IN (values)</code>
	 */
	public java.util.List<Variable> fetchByMultipleResponse(java.lang.Boolean... values) {
		return fetch(org.openforis.calc.persistence.jooq.tables.VariableTable.VARIABLE.MULTIPLE_RESPONSE, values);
	}

	/**
	 * Fetch records that have <code>override IN (values)</code>
	 */
	public java.util.List<Variable> fetchByOverride(java.lang.Boolean... values) {
		return fetch(org.openforis.calc.persistence.jooq.tables.VariableTable.VARIABLE.OVERRIDE, values);
	}

	/**
	 * Fetch records that have <code>degenerate_dimension IN (values)</code>
	 */
	public java.util.List<Variable> fetchByDegenerateDimension(java.lang.Boolean... values) {
		return fetch(org.openforis.calc.persistence.jooq.tables.VariableTable.VARIABLE.DEGENERATE_DIMENSION, values);
	}

	/**
	 * Fetch records that have <code>input_category_id_column IN (values)</code>
	 */
	public java.util.List<Variable> fetchByInputCategoryIdColumn(java.lang.String... values) {
		return fetch(org.openforis.calc.persistence.jooq.tables.VariableTable.VARIABLE.INPUT_CATEGORY_ID_COLUMN, values);
	}

	/**
	 * Fetch records that have <code>disaggregate IN (values)</code>
	 */
	public java.util.List<Variable> fetchByDisaggregate(java.lang.Boolean... values) {
		return fetch(org.openforis.calc.persistence.jooq.tables.VariableTable.VARIABLE.DISAGGREGATE, values);
	}

	/**
	 * Fetch records that have <code>output_value_column IN (values)</code>
	 */
	public java.util.List<Variable> fetchByOutputValueColumn(java.lang.String... values) {
		return fetch(org.openforis.calc.persistence.jooq.tables.VariableTable.VARIABLE.OUTPUT_VALUE_COLUMN, values);
	}

	/**
	 * Fetch records that have <code>caption IN (values)</code>
	 */
	public java.util.List<Variable> fetchByCaption(java.lang.String... values) {
		return fetch(org.openforis.calc.persistence.jooq.tables.VariableTable.VARIABLE.CAPTION, values);
	}

	/**
	 * Fetch records that have <code>description IN (values)</code>
	 */
	public java.util.List<Variable> fetchByDescription(java.lang.String... values) {
		return fetch(org.openforis.calc.persistence.jooq.tables.VariableTable.VARIABLE.DESCRIPTION, values);
	}

	/**
	 * Fetch records that have <code>sort_order IN (values)</code>
	 */
	public java.util.List<Variable> fetchBySortOrder(java.lang.Integer... values) {
		return fetch(org.openforis.calc.persistence.jooq.tables.VariableTable.VARIABLE.SORT_ORDER, values);
	}

	/**
	 * Fetch records that have <code>variable_per_ha_id IN (values)</code>
	 */
	public java.util.List<Variable> fetchByVariablePerHaId(java.lang.Integer... values) {
		return fetch(org.openforis.calc.persistence.jooq.tables.VariableTable.VARIABLE.VARIABLE_PER_HA_ID, values);
	}

	/**
	 * Fetch records that have <code>category_level_id IN (values)</code>
	 */
	public java.util.List<Variable> fetchByCategoryLevelId(java.lang.Long... values) {
		return fetch(org.openforis.calc.persistence.jooq.tables.VariableTable.VARIABLE.CATEGORY_LEVEL_ID, values);
	}
}