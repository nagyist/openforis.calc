package org.openforis.calc.chain.pre;

import static org.openforis.calc.persistence.jooq.Tables.SRS;
import static org.openforis.calc.persistence.postgis.PsqlBuilder.quote;

import java.util.List;

import org.jooq.Field;
import org.jooq.Table;
import org.jooq.Update;
import org.jooq.impl.DSL;
import org.openforis.calc.engine.Task;
import org.openforis.calc.engine.Workspace;
import org.openforis.calc.metadata.Entity;
import org.openforis.calc.persistence.postgis.Psql;
import org.openforis.calc.persistence.postgis.PsqlBuilder;
import org.openforis.calc.persistence.postgis.UpdateWithStep;
import org.openforis.calc.schema.OutputDataTable;
import org.openforis.calc.schema.OutputSchema;

/**
 * Update Point columns, taking X, Y and SRSID from other columns and converting them to the default SRS.
 * 
 * @author G. Miceli
 * @author M. Togna
 */
public final class CreateLocationColumnsTask extends Task {
	
	public static final String LOCATION_COLUMN = "_location";	
	private static final String TO_WGS84 = "ST_Transform(ST_SetSRID(ST_Point(%s::float,%s::float),srid),4326)";
	
	private static final String SRS_TABLE = "calc.srs";
	private static final String SRS_ID_COLUMN = "srs_id";
	
	@Override
	protected void execute() throws Throwable {
		//TODO
		OutputSchema outputSchema = getOutputSchema();
		for ( OutputDataTable dataTable : outputSchema.getDataTables() ) {
			Entity entity = dataTable.getEntity();
			if ( entity.isGeoreferenced() ) {
				if ( entity.getLocationColumn() == null ) {
					
					String xColumn = "\""+ entity.getXColumn() + "\"";
					String yColumn = "\"" + entity.getYColumn() + "\"";
					String srsColumn = entity.getSrsColumn();
					
					convertCoordinates(dataTable, xColumn, yColumn, srsColumn);
				} else {
					copyLocationColumn();
				}
			}
		}
		
//		oldExecute();
	}

	private void convertCoordinates(OutputDataTable dataTable, String xColumn, String yColumn, String srsColumn) {
		String expr = String.format(TO_WGS84, xColumn, yColumn);
		
		Table<?> cursor = new Psql().select().from(SRS).asTable("srs"); 
				
		Update<?> update = new Psql().update( dataTable ).set(dataTable.getLocationField(), DSL.field(expr, Psql.GEODETIC_COORDINATE_DATA_TYPE));
		
		Field<String> field = (Field<String>)dataTable.field(srsColumn);
		UpdateWithStep step = psql()
			.updateWith(cursor, update, field.eq( (Field<String>) cursor.field(SRS.SRS_ID)) );
		
		System.out.println(step.toString());
			step.execute();
	}

	private void oldExecute() {
		Workspace ws = getWorkspace();
		List<Entity> entities = ws.getEntities();
		for (Entity entity : entities) {
			if (entity.isGeoreferenced()) {
				String dataTable = quote(entity.getDataTable());
				createLocationColumn(dataTable);
				if ( entity.getLocationColumn() == null ) {
					String xColumn = quote(entity.getXColumn());
					String yColumn = quote(entity.getYColumn());
					String srsColumn = quote(entity.getSrsColumn());
					convertCoordinates(dataTable, xColumn, yColumn, srsColumn);
				} else {
					copyLocationColumn(dataTable);
				}
			}
		}
	}

	private void convertCoordinates(String dataTable, String xColumn, String yColumn, String srsColumn) {
		String expr = String.format(TO_WGS84, xColumn, yColumn);
		createPsqlBuilder()
			.update(dataTable+" f")
			.set(LOCATION_COLUMN + "=" + expr)
			.from(SRS_TABLE)
			.where(SRS_TABLE+"."+SRS_ID_COLUMN+" = f."+srsColumn)
			.execute();
	}

	private void createLocationColumn(String dataTable) {
		createPsqlBuilder()
			.alterTable(dataTable)
			.addColumn(LOCATION_COLUMN, PsqlBuilder.POINT4326)
			.execute();
	}

	private void copyLocationColumn() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not yet implemented");
	}
	
	private void copyLocationColumn(String dataTable) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not yet implemented");
	}

		
}