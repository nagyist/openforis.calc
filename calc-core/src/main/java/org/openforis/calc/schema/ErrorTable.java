/**
 * 
 */
package org.openforis.calc.schema;

import static org.jooq.util.postgres.PostgresDataType.DOUBLEPRECISION;

import org.jooq.Field;
import org.jooq.Schema;
import org.openforis.calc.metadata.Aoi;
import org.openforis.calc.metadata.CategoricalVariable;
import org.openforis.calc.metadata.QuantitativeVariable;
import org.openforis.calc.utils.StringUtils;

/**
 * Representation of the error table 
 * 
 * @author Mino Togna
 *
 */
public class ErrorTable extends AbstractTable {
	private static final long serialVersionUID = 1L;
	
	// constants used to format table and column names
	private static final String TABLE_NAME_FORMAT = "_error_%s_%s_%s";
	private static final String ABSOLUTE_ERROR = "absolute_error";
	private static final String RELATIVE_ERROR = "relative_error";
	private static final String VARIANCE = "variance";
	private static final String MEAN = "mean";
	private static final String TOTAL = "total";
	private String columnNameFormat = "";
	
	// instance variables 
	private QuantitativeVariable quantitativeVariable;
	private Aoi aoi;
	
	// fields
	private Field<Double> meanQuantityVariance;
	private Field<Double> meanQuantityRelativeError;
	private Field<Double> meanQuantityAbsoluteError;
	
	private Field<Double> totalQuantityVariance;
	private Field<Double> totalQuantityRelativeError;
	private Field<Double> totalQuantityAbsoluteError;
	private CategoricalVariable<?> categoricalVariable;
	
	protected ErrorTable(QuantitativeVariable quantitativeVariable , Aoi aoi , CategoricalVariable<?> categoricalVariable , Schema schema){
		super( getTableName(quantitativeVariable , aoi , categoricalVariable) , schema );
		
		this.quantitativeVariable = quantitativeVariable;
		this.categoricalVariable = categoricalVariable;
		this.aoi = aoi;
		
		this.columnNameFormat = "%s_"+this.quantitativeVariable.getName()+"_"+this.categoricalVariable.getName()+"_"+StringUtils.normalize(aoi.getCaption())+"_%s";
		
		initFields();
		
	}
	
	private void initFields(){
		// mean_volume_vegetation_type_atlantis_absolute_error
		this.meanQuantityAbsoluteError	= createField( getFieldName(MEAN , ABSOLUTE_ERROR), DOUBLEPRECISION, this );
		this.meanQuantityRelativeError	= createField( getFieldName(MEAN , RELATIVE_ERROR), DOUBLEPRECISION, this );
		this.meanQuantityVariance		= createField( getFieldName(MEAN , VARIANCE), DOUBLEPRECISION, this );
		
		this.totalQuantityAbsoluteError = createField( getFieldName(TOTAL , ABSOLUTE_ERROR), DOUBLEPRECISION, this );
		this.totalQuantityRelativeError = createField( getFieldName(TOTAL , RELATIVE_ERROR), DOUBLEPRECISION, this );
		this.totalQuantityVariance		= createField( getFieldName(TOTAL , VARIANCE), DOUBLEPRECISION, this );
	}

	private String getFieldName(String string1 , String string2){
		return String.format(columnNameFormat, string1 , string2);
	}

	private static String getTableName( QuantitativeVariable quantitativeVariable , Aoi aoi , CategoricalVariable<?> categoricalVariable ){
		String name = String.format( TABLE_NAME_FORMAT, quantitativeVariable.getName() , categoricalVariable.getName() , aoi.getCaption() );
		return StringUtils.normalize( name );
	}
	
	// getter methods
	public QuantitativeVariable getQuantitativeVariable() {
		return quantitativeVariable;
	}

	public CategoricalVariable<?> getCategoricalVariable() {
		return categoricalVariable;
	}
	
	public Aoi getAoi() {
		return aoi;
	}

	public Field<Double> getMeanQuantityVariance() {
		return meanQuantityVariance;
	}

	public Field<Double> getMeanQuantityRelativeError() {
		return meanQuantityRelativeError;
	}

	public Field<Double> getMeanQuantityAbsoluteError() {
		return meanQuantityAbsoluteError;
	}

	public Field<Double> getTotalQuantityVariance() {
		return totalQuantityVariance;
	}

	public Field<Double> getTotalQuantityRelativeError() {
		return totalQuantityRelativeError;
	}

	public Field<Double> getTotalQuantityAbsoluteError() {
		return totalQuantityAbsoluteError;
	}

}
