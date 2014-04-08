package org.openforis.calc.schema;

import org.openforis.calc.engine.Workspace;

/**
 * 
 * @author G. Miceli
 *
 */
public class Schemas {
	
	private DataSchema inputSchema;
//	private OutputSchema outputSchema;
	private RolapSchema rolapSchema;
	private Workspace workspace;
	
	public Schemas(Workspace workspace) {
		this.workspace = workspace;
		
		inputSchema = new DataSchema(workspace);
//		outputSchema = new OutputSchema(workspace, inputSchema);
		rolapSchema = new RolapSchema(workspace, inputSchema);
	}

	public DataSchema getDataSchema() {
		return inputSchema;
	}

//	public OutputSchema getOutputSchema() {
//		return outputSchema;
//	}

	public RolapSchema getRolapSchema() {
		return rolapSchema;
	}

	public Workspace getWorkspace() {
		return this.workspace;
	}
}
