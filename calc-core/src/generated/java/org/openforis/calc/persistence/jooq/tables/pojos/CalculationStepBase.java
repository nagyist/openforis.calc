/**
 * This class is generated by jOOQ
 */
package org.openforis.calc.persistence.jooq.tables.pojos;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.1" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CalculationStepBase implements java.io.Serializable {

	private static final long serialVersionUID = 1260849944;

	private java.lang.Integer                             id;
	private java.lang.Integer                             chainId;
	private java.lang.Integer                             stepNo;
	private java.lang.String                              moduleName;
	private java.lang.String                              moduleVersion;
	private java.lang.String                              operationName;
	private java.lang.String                              script;
	private org.openforis.calc.engine.ParameterMap        parameters;
	private java.lang.String                              caption;
	private java.lang.String                              description;
	private java.lang.Integer                             outputVariableId;
	private org.openforis.calc.chain.CalculationStep.Type type;
	private java.lang.Long                                equationListId;
	private org.openforis.calc.engine.ParameterMap        aggregateParameters;
	private java.lang.Boolean                             active;

	public CalculationStepBase() {}

	public CalculationStepBase(
		java.lang.Integer                             id,
		java.lang.Integer                             chainId,
		java.lang.Integer                             stepNo,
		java.lang.String                              moduleName,
		java.lang.String                              moduleVersion,
		java.lang.String                              operationName,
		java.lang.String                              script,
		org.openforis.calc.engine.ParameterMap        parameters,
		java.lang.String                              caption,
		java.lang.String                              description,
		java.lang.Integer                             outputVariableId,
		org.openforis.calc.chain.CalculationStep.Type type,
		java.lang.Long                                equationListId,
		org.openforis.calc.engine.ParameterMap        aggregateParameters,
		java.lang.Boolean                             active
	) {
		this.id = id;
		this.chainId = chainId;
		this.stepNo = stepNo;
		this.moduleName = moduleName;
		this.moduleVersion = moduleVersion;
		this.operationName = operationName;
		this.script = script;
		this.parameters = parameters;
		this.caption = caption;
		this.description = description;
		this.outputVariableId = outputVariableId;
		this.type = type;
		this.equationListId = equationListId;
		this.aggregateParameters = aggregateParameters;
		this.active = active;
	}

	public java.lang.Integer getId() {
		return this.id;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getChainId() {
		return this.chainId;
	}

	public void setChainId(java.lang.Integer chainId) {
		this.chainId = chainId;
	}

	public java.lang.Integer getStepNo() {
		return this.stepNo;
	}

	public void setStepNo(java.lang.Integer stepNo) {
		this.stepNo = stepNo;
	}

	public java.lang.String getModuleName() {
		return this.moduleName;
	}

	public void setModuleName(java.lang.String moduleName) {
		this.moduleName = moduleName;
	}

	public java.lang.String getModuleVersion() {
		return this.moduleVersion;
	}

	public void setModuleVersion(java.lang.String moduleVersion) {
		this.moduleVersion = moduleVersion;
	}

	public java.lang.String getOperationName() {
		return this.operationName;
	}

	public void setOperationName(java.lang.String operationName) {
		this.operationName = operationName;
	}

	public java.lang.String getScript() {
		return this.script;
	}

	public void setScript(java.lang.String script) {
		this.script = script;
	}

	public org.openforis.calc.engine.ParameterMap getParameters() {
		return this.parameters;
	}

	public void setParameters(org.openforis.calc.engine.ParameterMap parameters) {
		this.parameters = parameters;
	}

	public java.lang.String getCaption() {
		return this.caption;
	}

	public void setCaption(java.lang.String caption) {
		this.caption = caption;
	}

	public java.lang.String getDescription() {
		return this.description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}

	public java.lang.Integer getOutputVariableId() {
		return this.outputVariableId;
	}

	public void setOutputVariableId(java.lang.Integer outputVariableId) {
		this.outputVariableId = outputVariableId;
	}

	public org.openforis.calc.chain.CalculationStep.Type getType() {
		return this.type;
	}

	public void setType(org.openforis.calc.chain.CalculationStep.Type type) {
		this.type = type;
	}

	public java.lang.Long getEquationListId() {
		return this.equationListId;
	}

	public void setEquationListId(java.lang.Long equationListId) {
		this.equationListId = equationListId;
	}

	public org.openforis.calc.engine.ParameterMap getAggregateParameters() {
		return this.aggregateParameters;
	}

	public void setAggregateParameters(org.openforis.calc.engine.ParameterMap aggregateParameters) {
		this.aggregateParameters = aggregateParameters;
	}

	public java.lang.Boolean getActive() {
		return this.active;
	}

	public void setActive(java.lang.Boolean active) {
		this.active = active;
	}
}