/**
 * Equation list manager 
 * @author Mino Togna
 */

EquationListManager = function( container ) {
	this.BASE_URI = "rest/workspace/active/settings/equationList/"
	/* UI components */
	this.container = $( container );
	
	// View section
	this.viewSection	= this.container.find( ".view-section" );
	this.equationLists	= this.viewSection.find( ".equation-lists" );
	this.equationsTable = this.viewSection.find( "table.equations-table" );
	
	// upload section
	this.form 		= this.container.find( ".upload-csv-form" );
	this.uploadBtn 	= this.form.find( "[name=upload-btn]" );
	this.file 		= this.form.find( "[name=file]" );
	
	// import section
	this.importSection	= this.container.find( ".import-section" );
	this.listName		= this.importSection.find( "[name=list-name]" );
	this.filePath		= "";
	this.importBtn		= this.importSection.find( "[name=import-btn]" );
	
	this.init();
};


EquationListManager.prototype.init = function() {
	// reset edit form
	this.selectedListId = null;
	
	// hide equations table
	this.equationsTable.hide();
	
	var $this = this;
	// bind events
	this.form.ajaxForm({
	    dataType : 'json',
	    beforeSubmit: function() {
	    	UI.lock();
	    },
	    uploadProgress: function ( event, position, total, percentComplete ) {
	    },
	    success: function ( response ) {
	    	$this.showImport( response.fields.filepath, response.fields.headers );
	    },
	    error: function () {
			Calc.error.apply( this , arguments );
	    },
	    complete: function() {
	    	// reset upload form
	    	$this.fileUpload.reset();
	    	UI.unlock();
	    }
	});	
	
	//init file upload
	this.fileUpload = new FileUpload(this.uploadBtn, this.file, function(e) {
		$this.form.submit();
	});
	
	// import event handlers
	this.importBtn.click( function(e) {
		e.preventDefault();
		
		var listName = $.trim( $this.listName.val() );
		
		if( listName == "" ) {
			UI.showError( "List name cannot be blank" , true );
		} else {
			WorkspaceManager.getInstance().activeWorkspaceImportEquationList( $this.filePath , listName , $this.selectedListId , function(ws) {
				$this.showList();
			} );
		}
		
	});
	
	// show lists
	this.showList();
};

EquationListManager.prototype.showImport = function( filepath ) {
	var $this = this;
	
	// after file upload 
	this.listName.val("");
	this.filePath = filepath ;
	
	this.viewSection.hide();
	this.importSection.fadeIn();
};
/**
 * Update equation lists UI
 */
EquationListManager.prototype.showList = function() {
	this.importSection.hide();
	this.viewSection.show();
	this.equationLists.empty();
	 
	var $this = this;
	WorkspaceManager.getInstance().activeWorkspace( function(ws) {
		$.each( ws.equationLists , function( i , eq ){
			
			var addButton = function( ){
				
				var btn = $( '<button class="btn option-btn width100"></button>' );
				btn.hide();
				btn.html( eq.name );
				$this.equationLists.append( btn );
				setTimeout( function(){
					btn.fadeIn();
				} , i * 75);
				
				
				var optionBtn = new OptionButton( btn );
				
				var select = function( list ) {
					
					// unselect last selection 
					if( $this.lastSelection ){
						$this.lastSelection.deselect();
					}
					
					UI.lock();
					var tbody = $this.equationsTable.find("tbody");
					tbody.empty();
					$this.equationsTable.show();
					$.ajax({
						url			: $this.BASE_URI + list.id + "/equations.json" ,
						method		: "GET" ,
						dataType	: "json"
					}).done( function(response) {
						UI.unlock();
						
						var equations = response.fields.equations;
						$.each( equations , function( j , equation) {
							var tr = $( "<tr style='font-size:0.9em'></tr>" );
							tr.hide();
							tbody.append( tr );
							
							var td = $( "<td></td>" );
							td.html( equation.code );
							tr.append( td );
							
							td = $( "<td></td>" );
							td.html( equation.equation );
							tr.append( td );
							
							td = $( "<td></td>" );
							td.html( equation.condition );
							tr.append( td );
							
							setTimeout( function(){
								tr.fadeIn();
							} , j * 75);
							
							$this.selectedListButton = optionBtn;
							$this.selectedListId 	= list.id; 
						});
					}).error(function(){
						Calc.error.apply( this, arguments );
					})
				};
				optionBtn.select( select , eq );
				
				var deselect = function( e ){
					$this.equationsTable.fadeOut();
					
					$this.selectedListButton = null;
					$this.selectedListId 	= null;
				};
				optionBtn.deselect( deselect , eq )
			}
			
			addButton();
		});
		
	});
	
};