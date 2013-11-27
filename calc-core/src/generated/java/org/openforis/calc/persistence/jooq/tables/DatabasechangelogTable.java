/**
 * This class is generated by jOOQ
 */
package org.openforis.calc.persistence.jooq.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.1.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DatabasechangelogTable extends org.jooq.impl.TableImpl<org.jooq.Record> {

	private static final long serialVersionUID = -59047422;

	/**
	 * The singleton instance of <code>calc.databasechangelog</code>
	 */
	public static final org.openforis.calc.persistence.jooq.tables.DatabasechangelogTable DATABASECHANGELOG = new org.openforis.calc.persistence.jooq.tables.DatabasechangelogTable();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.jooq.Record> getRecordType() {
		return org.jooq.Record.class;
	}

	/**
	 * The column <code>calc.databasechangelog.id</code>. 
	 */
	public final org.jooq.TableField<org.jooq.Record, java.lang.String> ID = createField("id", org.jooq.impl.SQLDataType.VARCHAR.length(63), this);

	/**
	 * The column <code>calc.databasechangelog.author</code>. 
	 */
	public final org.jooq.TableField<org.jooq.Record, java.lang.String> AUTHOR = createField("author", org.jooq.impl.SQLDataType.VARCHAR.length(63), this);

	/**
	 * The column <code>calc.databasechangelog.filename</code>. 
	 */
	public final org.jooq.TableField<org.jooq.Record, java.lang.String> FILENAME = createField("filename", org.jooq.impl.SQLDataType.VARCHAR.length(200), this);

	/**
	 * The column <code>calc.databasechangelog.dateexecuted</code>. 
	 */
	public final org.jooq.TableField<org.jooq.Record, java.sql.Timestamp> DATEEXECUTED = createField("dateexecuted", org.jooq.impl.SQLDataType.TIMESTAMP, this);

	/**
	 * The column <code>calc.databasechangelog.orderexecuted</code>. 
	 */
	public final org.jooq.TableField<org.jooq.Record, java.lang.Integer> ORDEREXECUTED = createField("orderexecuted", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The column <code>calc.databasechangelog.exectype</code>. 
	 */
	public final org.jooq.TableField<org.jooq.Record, java.lang.String> EXECTYPE = createField("exectype", org.jooq.impl.SQLDataType.VARCHAR.length(10), this);

	/**
	 * The column <code>calc.databasechangelog.md5sum</code>. 
	 */
	public final org.jooq.TableField<org.jooq.Record, java.lang.String> MD5SUM = createField("md5sum", org.jooq.impl.SQLDataType.VARCHAR.length(35), this);

	/**
	 * The column <code>calc.databasechangelog.description</code>. 
	 */
	public final org.jooq.TableField<org.jooq.Record, java.lang.String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>calc.databasechangelog.comments</code>. 
	 */
	public final org.jooq.TableField<org.jooq.Record, java.lang.String> COMMENTS = createField("comments", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>calc.databasechangelog.tag</code>. 
	 */
	public final org.jooq.TableField<org.jooq.Record, java.lang.String> TAG = createField("tag", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>calc.databasechangelog.liquibase</code>. 
	 */
	public final org.jooq.TableField<org.jooq.Record, java.lang.String> LIQUIBASE = createField("liquibase", org.jooq.impl.SQLDataType.VARCHAR.length(20), this);

	/**
	 * Create a <code>calc.databasechangelog</code> table reference
	 */
	public DatabasechangelogTable() {
		super("databasechangelog", org.openforis.calc.persistence.jooq.CalcSchema.CALC);
	}

	/**
	 * Create an aliased <code>calc.databasechangelog</code> table reference
	 */
	public DatabasechangelogTable(java.lang.String alias) {
		super(alias, org.openforis.calc.persistence.jooq.CalcSchema.CALC, org.openforis.calc.persistence.jooq.tables.DatabasechangelogTable.DATABASECHANGELOG);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<org.jooq.Record> getPrimaryKey() {
		return org.openforis.calc.persistence.jooq.Keys.PK_DATABASECHANGELOG;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<org.jooq.Record>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.jooq.Record>>asList(org.openforis.calc.persistence.jooq.Keys.PK_DATABASECHANGELOG);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.openforis.calc.persistence.jooq.tables.DatabasechangelogTable as(java.lang.String alias) {
		return new org.openforis.calc.persistence.jooq.tables.DatabasechangelogTable(alias);
	}
}