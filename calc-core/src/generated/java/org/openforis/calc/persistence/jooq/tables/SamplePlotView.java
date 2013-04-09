/**
 * This class is generated by jOOQ
 */
package org.openforis.calc.persistence.jooq.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "2.6.0"},
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings("all")
public class SamplePlotView extends org.jooq.impl.TableImpl<org.openforis.calc.persistence.jooq.tables.records.SamplePlotViewRecord> {

	private static final long serialVersionUID = -2037777466;

	/**
	 * The singleton instance of calc.sample_plot_view
	 */
	public static final org.openforis.calc.persistence.jooq.tables.SamplePlotView SAMPLE_PLOT_VIEW = new org.openforis.calc.persistence.jooq.tables.SamplePlotView();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.openforis.calc.persistence.jooq.tables.records.SamplePlotViewRecord> getRecordType() {
		return org.openforis.calc.persistence.jooq.tables.records.SamplePlotViewRecord.class;
	}

	/**
	 * The table column <code>calc.sample_plot_view.survey_id</code>
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.SamplePlotViewRecord, java.lang.Integer> SURVEY_ID = createField("survey_id", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The table column <code>calc.sample_plot_view.plot_obs_unit_id</code>
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.SamplePlotViewRecord, java.lang.Integer> PLOT_OBS_UNIT_ID = createField("plot_obs_unit_id", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The table column <code>calc.sample_plot_view.plot_obs_unit_name</code>
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.SamplePlotViewRecord, java.lang.String> PLOT_OBS_UNIT_NAME = createField("plot_obs_unit_name", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * The table column <code>calc.sample_plot_view.stratum_id</code>
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.SamplePlotViewRecord, java.lang.Integer> STRATUM_ID = createField("stratum_id", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The table column <code>calc.sample_plot_view.stratum_no</code>
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.SamplePlotViewRecord, java.lang.Integer> STRATUM_NO = createField("stratum_no", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The table column <code>calc.sample_plot_view.cluster_id</code>
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.SamplePlotViewRecord, java.lang.Integer> CLUSTER_ID = createField("cluster_id", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The table column <code>calc.sample_plot_view.cluster_code</code>
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.SamplePlotViewRecord, java.lang.String> CLUSTER_CODE = createField("cluster_code", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * The table column <code>calc.sample_plot_view.cluster_x</code>
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.SamplePlotViewRecord, java.lang.Integer> CLUSTER_X = createField("cluster_x", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The table column <code>calc.sample_plot_view.cluster_y</code>
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.SamplePlotViewRecord, java.lang.Integer> CLUSTER_Y = createField("cluster_y", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The table column <code>calc.sample_plot_view.sample_plot_id</code>
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.SamplePlotViewRecord, java.lang.Integer> SAMPLE_PLOT_ID = createField("sample_plot_id", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The table column <code>calc.sample_plot_view.plot_no</code>
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.SamplePlotViewRecord, java.lang.Integer> PLOT_NO = createField("plot_no", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The table column <code>calc.sample_plot_view.plot_location</code>
	 * <p>
	 * The SQL type of this item (USER-DEFINED, geometry) could not be mapped.<br/>
	 * Deserialising this field might not work!
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.SamplePlotViewRecord, java.lang.Object> PLOT_LOCATION = createField("plot_location", org.jooq.util.postgres.PostgresDataType.getDefaultDataType("USER-DEFINED"), this);

	/**
	 * The table column <code>calc.sample_plot_view.plot_shape</code>
	 * <p>
	 * The SQL type of this item (USER-DEFINED, geometry) could not be mapped.<br/>
	 * Deserialising this field might not work!
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.SamplePlotViewRecord, java.lang.Object> PLOT_SHAPE = createField("plot_shape", org.jooq.util.postgres.PostgresDataType.getDefaultDataType("USER-DEFINED"), this);

	/**
	 * The table column <code>calc.sample_plot_view.sampling_phase</code>
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.SamplePlotViewRecord, java.lang.Integer> SAMPLING_PHASE = createField("sampling_phase", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The table column <code>calc.sample_plot_view.ground_plot</code>
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.SamplePlotViewRecord, java.lang.Boolean> GROUND_PLOT = createField("ground_plot", org.jooq.impl.SQLDataType.BOOLEAN, this);

	/**
	 * The table column <code>calc.sample_plot_view.permanent_plot</code>
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.SamplePlotViewRecord, java.lang.Boolean> PERMANENT_PLOT = createField("permanent_plot", org.jooq.impl.SQLDataType.BOOLEAN, this);

	public SamplePlotView() {
		super("sample_plot_view", org.openforis.calc.persistence.jooq.Calc.CALC);
	}

	public SamplePlotView(java.lang.String alias) {
		super(alias, org.openforis.calc.persistence.jooq.Calc.CALC, org.openforis.calc.persistence.jooq.tables.SamplePlotView.SAMPLE_PLOT_VIEW);
	}

	@Override
	public org.openforis.calc.persistence.jooq.tables.SamplePlotView as(java.lang.String alias) {
		return new org.openforis.calc.persistence.jooq.tables.SamplePlotView(alias);
	}
}