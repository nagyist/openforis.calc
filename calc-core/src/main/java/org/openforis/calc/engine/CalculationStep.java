package org.openforis.calc.engine;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.openforis.calc.common.UserObject;

/**
 * A single user-defined step in the {@link ProcessingChain}
 * @author G. Miceli
 *
 */
@javax.persistence.Entity
@Table(name = "calculation_step")
public final class CalculationStep extends UserObject {
	@Column(name = "module_name")
	private String moduleName;
	
	@Column(name = "module_version")
	private String moduleVersion;
	
	@Column(name = "operation_name")
	private String operationName;
		
	@Column(name = "step_no")
	private int stepNo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "chain_id")
	private ProcessingChain chain;
	
	@Transient
	private ParameterMap operationParameters;

	public ProcessingChain getChain() {
		return this.chain;
	}

	public ParameterMap getOperationParameters() {
		return this.operationParameters;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleName() {
		return this.moduleName;
	}

	public void setModuleVersion(String moduleVersion) {
		this.moduleVersion = moduleVersion;
	}

	public String getModuleVersion() {
		return this.moduleVersion;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String getOperationName() {
		return this.operationName;
	}

	public void setStepNo(int index) {
		this.stepNo = index;
	}

	public int getStepNo() {
		return this.stepNo;
	}
}