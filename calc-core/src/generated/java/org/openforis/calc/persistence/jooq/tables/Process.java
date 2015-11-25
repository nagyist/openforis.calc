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
public class Process extends org.jooq.impl.UpdatableTableImpl<org.openforis.calc.persistence.jooq.tables.records.ProcessRecord> {

	private static final long serialVersionUID = 1496105778;

	/**
	 * The singleton instance of calc.process
	 */
	public static final org.openforis.calc.persistence.jooq.tables.Process PROCESS = new org.openforis.calc.persistence.jooq.tables.Process();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.openforis.calc.persistence.jooq.tables.records.ProcessRecord> getRecordType() {
		return org.openforis.calc.persistence.jooq.tables.records.ProcessRecord.class;
	}

	/**
	 * The table column <code>calc.process.process_id</code>
	 * <p>
	 * This column is part of the table's PRIMARY KEY
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.ProcessRecord, java.lang.Integer> PROCESS_ID = createField("process_id", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The table column <code>calc.process.chain_id</code>
	 * <p>
	 * This column is part of a FOREIGN KEY: <code><pre>
	 * CONSTRAINT process__fk_process_processing_chain
	 * FOREIGN KEY (chain_id)
	 * REFERENCES calc.processing_chain (processing_chain_id)
	 * </pre></code>
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.ProcessRecord, java.lang.Integer> CHAIN_ID = createField("chain_id", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The table column <code>calc.process.operation_id</code>
	 * <p>
	 * This column is part of a FOREIGN KEY: <code><pre>
	 * CONSTRAINT process__fk_process_operation
	 * FOREIGN KEY (operation_id)
	 * REFERENCES calc.operation (operation_id)
	 * </pre></code>
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.ProcessRecord, java.lang.Integer> OPERATION_ID = createField("operation_id", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The table column <code>calc.process.process_description</code>
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.ProcessRecord, java.lang.String> PROCESS_DESCRIPTION = createField("process_description", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * The table column <code>calc.process.process_order</code>
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.ProcessRecord, java.lang.Integer> PROCESS_ORDER = createField("process_order", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The table column <code>calc.process.process_label</code>
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.ProcessRecord, java.lang.String> PROCESS_LABEL = createField("process_label", org.jooq.impl.SQLDataType.VARCHAR, this);

	public Process() {
		super("process", org.openforis.calc.persistence.jooq.Calc.CALC);
	}

	public Process(java.lang.String alias) {
		super(alias, org.openforis.calc.persistence.jooq.Calc.CALC, org.openforis.calc.persistence.jooq.tables.Process.PROCESS);
	}

	@Override
	public org.jooq.Identity<org.openforis.calc.persistence.jooq.tables.records.ProcessRecord, java.lang.Integer> getIdentity() {
		return org.openforis.calc.persistence.jooq.Keys.IDENTITY_PROCESS;
	}

	@Override
	public org.jooq.UniqueKey<org.openforis.calc.persistence.jooq.tables.records.ProcessRecord> getMainKey() {
		return org.openforis.calc.persistence.jooq.Keys.PROCESS_PKEY;
	}

	@Override
	@SuppressWarnings("unchecked")
	public java.util.List<org.jooq.UniqueKey<org.openforis.calc.persistence.jooq.tables.records.ProcessRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.openforis.calc.persistence.jooq.tables.records.ProcessRecord>>asList(org.openforis.calc.persistence.jooq.Keys.PROCESS_PKEY);
	}

	@Override
	@SuppressWarnings("unchecked")
	public java.util.List<org.jooq.ForeignKey<org.openforis.calc.persistence.jooq.tables.records.ProcessRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<org.openforis.calc.persistence.jooq.tables.records.ProcessRecord, ?>>asList(org.openforis.calc.persistence.jooq.Keys.PROCESS__FK_PROCESS_PROCESSING_CHAIN, org.openforis.calc.persistence.jooq.Keys.PROCESS__FK_PROCESS_OPERATION);
	}

	@Override
	public org.openforis.calc.persistence.jooq.tables.Process as(java.lang.String alias) {
		return new org.openforis.calc.persistence.jooq.tables.Process(alias);
	}
}