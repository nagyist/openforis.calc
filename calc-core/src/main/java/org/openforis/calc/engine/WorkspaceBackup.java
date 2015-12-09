/**
 * 
 */
package org.openforis.calc.engine;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.openforis.calc.metadata.CategoryLevel.CategoryLevelValue;

/**
 * Wrapper class for workspace backup used for export/import functionality
 * 
 * @author Mino Togna
 * 
 */
public class WorkspaceBackup {

	private Workspace workspace;

	private String version;

	/**
	 * Map of variables (Calc id -> Original id)
	 */
	private Map<Integer, Integer> variableOriginalIds;

	/**
	 * map of category classes ( CategoryLevelId -> List<CategoryLevelValue> )
	 */
	private Map<Integer, List<CategoryLevelValue>> categoryLevelValues;
	
	private ExternalData phase1Data;

	private ExternalData primarySuData;
	
	public WorkspaceBackup(){
		super();
	}

	public WorkspaceBackup( Workspace ws ){
		this.workspace = ws;
	}

	public Workspace getWorkspace() {
		return workspace;
	}

	public void setWorkspace( Workspace workspace ) {
		this.workspace = workspace;
	}

	public String getVersion() {
		return version;
	}

	public ExternalData getPhase1Data() {
		return phase1Data;
	}
	
	public ExternalData getPrimarySuData() {
		return primarySuData;
	}
	
	public Map<Integer, Integer> getVariableOriginalIds() {
		return variableOriginalIds;
	}
	
	public Map<Integer, List<CategoryLevelValue>> getCategoryLevelValues() {
		return categoryLevelValues;
	}
	
	void setVersion( String version ) {
		this.version = version;
	}

	void setVariableOriginalIds( Map<Integer, Integer> variableOriginalIds ) {
		this.variableOriginalIds = variableOriginalIds;
	}

	void setCategoryLevelValues( Map<Integer, List<CategoryLevelValue>> categoryLevelValues ) {
		this.categoryLevelValues = categoryLevelValues;
	}
	
	void setPhase1Data( ExternalData phase1Data ) {
		this.phase1Data = phase1Data;
	}
	
	void setPrimarySUData(ExternalData externalData) {
		this.primarySuData = externalData;
		
	}

	public static class ExternalData {
		
		public ExternalData(){
		}
		
		public ExternalData( JSONArray tableInfo , List<DataRecord> records ){
			this.tableInfo = tableInfo;
			this.records = records;
		}
		private JSONArray tableInfo;
		private List<DataRecord> records;
		
		public JSONArray getTableInfo() {
			return tableInfo;
		}
		
		public List<DataRecord> getRecords() {
			return records;
		}
		
	}

}