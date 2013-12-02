/**
 * 
 * Manager for calculation step execute and test sections
 * 
 * @author Mino Togna
 *  
 */
function CalculationStepExecManager(container, calculationStepResultsManager) {
	// main ui container
	this.container = container;
	// results container to show after job execution
	this.calculationStepResultsManager = calculationStepResultsManager;
	// header
	this.header = this.container.find(".header");
	//exec btn
	this.execButton = this.container.find('button[name=exec-btn]');
	
	//calc step associated. it's set by the show method 
	this.calculationStep = null;
	
	//job manager
	this.jobManager = new JobManager();
	
	this._init();
};

CalculationStepExecManager.prototype = (function() {
	
	/**
	 *  init function
	 * @param callback
	 */
	var init = function() {
		var $this = this;
		
		/*
		 * event handlers
		 */
		//start step execution on click
		this.execButton.click(function(e) {
			UI.disableAll();
			$this.jobManager.executeCalculationStep(
					$this.calculationStep.id, 
					//on complete show results
					function(job) {
//						console.log("job finished");
//						console.log(job);
						UI.enableAll();
						
						// once completed show results section
						$this.hide();
						$this.calculationStepResultsManager.show();
					}
					, true
			);
		});
	};
	
	/**
	 * show exec section
	 */
	var show = function(calculationStep) {
		this.calculationStep = calculationStep;
		
		// append legend with step name to header
		this.header.empty();
		var legend = $("<legend></legend>");
		legend.html(this.calculationStep.caption);
		this.header.append( legend );
		
		//show main container
		this.container.fadeIn(400);
	};
	
	var hide = function () {
		this.container.hide();
	};
	
	//prototype
	return {
		constructor : CalculationStepExecManager,
		
		//public methods
		_init : init,
		
		//show / hide 
		show : show
		,
		hide : hide
		
	};
})();
