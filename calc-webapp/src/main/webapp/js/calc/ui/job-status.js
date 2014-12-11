/**
 * Job Status modal div ui component (defined in index.html)
 * 
 * @author Mino Togna
 */
JobStatus = function() {
	
	this.container = $( "#job-status" );
	// status header text 
	this.status = this.container.find( ".status" );
	// ui container for the tasks
	this.taskSection = this.container.find( ".task-section" );
	// template for taskStatus
	this.taskStatus = $( "#task-status" );

	// log section
	this.logSection = this.container.find(".log-section");
	// log
	this.log = this.logSection.find(".log");
	// toggle-log-btn
	this.logBtn = this.logSection.find(".toggle-log-btn");
	
	// close button
	this.closeBtn = this.container.find(".close-btn");
	
	// current job
	this.job = null;
	
	// to download r code in case of calc job
	this.downloadRCodeButton	= this.container.find( '.download-r-code button' );
	this.downloadRCodeButton.click( function(e){
		e.preventDefault();
		JobManager.getInstance().downloadRCode(function(){
			
		});
	});
};

JobStatus.prototype = (function() {
	
	var show = function() {
		// first reset and then shows it
		$.proxy(reset, this)();
		
		this.container.modal( {keyboard:false, backdrop:"static"} );
	};
	
	// update task status
	var update = function(job, complete, hideOnComplete) {
		var $this = this;
		
		if(!this.job) {
			$.proxy(init, this)(job);
		}
		
		// update each task 
		var tasks = job.tasks;
		$.each(tasks, function(i, task) {
			var taskStatus =  $this.taskSection.find("#" + task.id);

			var progressBar = taskStatus.data("progress-bar");
			progressBar.update( task.itemsProcessed, task.totalItems );
			
			if( task.totalItems <= 0 ) {
				switch(task.status) {
					case "PENDING":
						progressBar.reset();
						break;
					case "RUNNING":
						progressBar.progressStriped();
						break;
					case "FAILED":
//						progressBar.progressDanger();
						console.log( "aaaaaaaaaaaaaaa" );
						break;
					case "COMPLETED":
						progressBar.progressSuccess();
						break;
					default:
				}
			}
			
			if(task.status == "FAILED") {
				progressBar.progressDanger();
				
				var div = $('<div></div>');
				div.hide();
				div.text( "Error in '" + task.name + "' \n " + task.errorStackTrace );
				$this.log.append(div);
				div.fadeIn(300);
				// scroll to the end of the log section
				setTimeout(function(){
					$this.log.stop().animate({
						scrollTop: div.offset().top
					}, 0);
				}, 1000);
			}

		});
		
		// update log if there is
		if( job.rlogger ) {
			var lines = job.rlogger.lines;
			var processedLines = this.log.children().length;
			var newLines = lines.slice(processedLines, lines.length);
			
			$.each(newLines, function(i, line){
				var div = $('<div></div>');
				div.hide();
				
				div.text(line.text);
				
				$this.log.append(div);
				
				div.fadeIn(300);
				
				// scroll only at the end
				if(i == newLines.length-1){
					setTimeout(function(){
						$this.log.stop().animate({
							scrollTop: div.offset().top
						}, 0);
					}, 1000);
				}
			});
		}
		
		// show/hide close btn
		switch(job.status) {
			case "PENDING":
			case "RUNNING":
				break;
			case "COMPLETED":
				this.closeBtn.on("click", function(){
					$this.hide(complete, job);
				});
				this.closeBtn.show();
				$.proxy(adjustSize, $this)();
				// auto hide disabled for now
//				if( hideOnComplete === true ) {
//					$this.hide(complete, job);
//				}
				break;
			case "FAILED":
				this.closeBtn.on("click", function(){
					$this.hide();
				});
				this.closeBtn.show();
				$.proxy(adjustSize, $this)();
				break;
			default:
//				this.closeBtn.show();
		}
	};
	
	var hide = function(callback, job) {
		this.container.modal( "hide" );
		$.proxy(reset,this)();
		if(callback){
			callback(job);
		}
	};
	
	// initialize ui with given job
	var init = function(job) {
		var $this = this;
		$this.job = job;
		
		this.status.html( this.job.status.toLowerCase() );
		
		var delay = 50;
		var tasks = this.job.tasks;
		$.each(tasks, function(i, task) {
			// add a row for each task
			var taskStatus = $this.taskStatus.clone();
			taskStatus.hide();
			
			taskStatus.attr("id", task.id);
			taskStatus.find(".number").text( (i+1) +"." );
			taskStatus.find(".name").text( task.name );
			// add a progress bar to each task
			var progressBar = new ProgressBar( taskStatus.find(".progress"), taskStatus.find(".percent") );
			taskStatus.data("progress-bar", progressBar);

			$this.taskSection.append(taskStatus);	

			setTimeout(function(){
				taskStatus.fadeIn(100);
			}, (delay+=50) );
		});
		
		// init r logger if calcjob
//		if( $this.job.rlogger ) {
			// show log section
			$this.logSection.show();
//			if( $this.logBtn.hasClass("option-btn-selected") ){
//				// set logSection height
//				var height = $(document).height() / 5;
//				$this.logSection.css({"height":height});
//			}
			
			var clickFunction = function(e){
				if( $this.logBtn.hasClass("option-btn-selected") ){
					$.proxy(hideLog, $this)();
				} else {
					$.proxy(showLog, $this)();
				}	
			};
			$this.logBtn.on("click", clickFunction);
//		}
		
		$(window).on("resize", $.proxy(adjustSize, $this));
		
		$.proxy(showLog, $this)();
		$.proxy(adjustSize, $this)();
		
		// show / hide download R code button
		if( $this.job.rlogger ) {
			this.downloadRCodeButton.show();
		} else {
			this.downloadRCodeButton.hide();
		}
	};

	var showLog = function() {
		var $this = this;
		$this.logBtn.removeClass("option-btn");
		$this.logBtn.addClass("option-btn-selected");
		
		//var height = $(document).height() / 5;
		var height = 130;
		this.logSection.animate({ height: height }, 600);
		this.log.animate({ opacity: "1" }, 600);
		
		$.proxy(adjustSize, $this)();
	};
	
	var hideLog = function() {
		var $this = this;
		$this.logBtn.removeClass("option-btn-selected");
		$this.logBtn.addClass("option-btn");
		
		$this.logSection.animate({ height: "80px" }, 600);
		setTimeout(function(){
			$this.log.animate({ opacity: ".2" }, 600);
		},800); 
		
		$.proxy(adjustSize, $this)();
	};
	
	var adjustSize = function() {
		var taskMinHeight = 90;
		
		var header = this.container.find(".modal-header");
		var footer = this.container.find(".modal-footer");
		var maxHeight = $(window).height() - 60; //max available height, excluding padding
		var otherPartsHeight = header.outerHeight() + footer.outerHeight();
		
		var bodyMaxHeight = maxHeight - otherPartsHeight - 30;
		var taskRequiredHeight = this.taskStatus.outerHeight() * this.taskSection.children().length;
		var taskMaxHeight = Math.max(taskMinHeight, taskRequiredHeight);
		
		var logOpen = this.logBtn.hasClass("option-btn-selected");
		var logSectionHeight = logOpen ? 130: 80;
		
		//if task section required height is greater than maximum available, reduce task section
		if ( taskRequiredHeight + logSectionHeight > bodyMaxHeight ) {
			taskMaxHeight = Math.max(taskMinHeight, bodyMaxHeight - logSectionHeight);
		}
		this.taskSection.css({maxHeight: taskMaxHeight});
	};
	
	// reset its internal state
	var reset = function() {
		this.status.html( "Waiting job status" );
		this.taskSection.empty();

		// empty log
		this.logSection.hide();
		this.log.empty();
//		this.log.css({ opacity: "1" });
		this.logBtn.off("click");
		UI.enable( this.logBtn );
		//(3 below lines) let's leave the last ui status. maybe users don't want to see the log? and always have to click it? 
//		this.log.show();
//		this.logBtn.removeClass("option-btn");
//		this.logBtn.addClass("option-btn-selected");
		
		this.closeBtn.off("click");
		this.closeBtn.hide();
		
		this.job = null;
		
		$(window).off("resize", $.proxy(adjustSize, this));
	};
	
	return {
		constructor : JobStatus
		,
		show : show
		,
		hide : hide
		,
		update : update
	};
	
})();