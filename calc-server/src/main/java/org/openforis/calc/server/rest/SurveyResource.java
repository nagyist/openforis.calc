package org.openforis.calc.server.rest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.openforis.calc.io.flat.FlatDataStream;
import org.openforis.calc.model.Survey;
import org.openforis.calc.persistence.SurveyDao;
import org.openforis.calc.service.ObservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * Root resource containing first-level sub-resource locator methods.

 * @author G. Miceli
 * @author Mino Togna
 *
 */
@Component
@Scope("request")
public class SurveyResource extends SubResource<String> {

	@Autowired
	private SurveyDao surveyDao;

	@Autowired
	private ObservationService observationService;
	
	@GET
    public FlatDataStream getSurveyData() {
    	return surveyDao.streamByName(getFields(), getKey());
    }
	
	@PATCH
	@Path("/area-results")
	@Deprecated
	public Response updateAreaFacts(FlatDataStream dataStream) throws URISyntaxException, IOException {

		// Process data stream and store results 
		observationService.updateAreaFacts(getKey(), dataStream);
		
		// Use OK response instead of created; HTTP PATCH may create or update
		return Response.ok(new URI("area-results")).entity("OK").build();
	}
	
//	@PATCH
//	@Path("/test")
//	public Response test(FlatDataStream dataStream) throws URISyntaxException, IOException {
//		System.out.println("=== Data Stream headers: "+ dataStream.getFieldNames() );
//		@SuppressWarnings("unused")
//		FlatRecord r = null;
//		int c = 0;
//		while( (r=dataStream.nextRecord()) != null ) {
//			Integer treeId = r.getValue("specimen_id", Integer.class);
//			Double estH = r.getValue("est_height", Double.class);
//			System.out.println( treeId  + " h: " + estH);
//			c++;
//		}
//		System.out.println( "=== # of lines: " + c);
//		// Process data stream and store results 
////		observationService.updateAreaFacts(getKey(), dataStream);
//		
//		// Use OK response instead of created; HTTP PATCH may create or update
//		return Response.ok(new URI("test")).entity("OK").build();
//	}	

	@Path("/units")
	public ObservationUnitListResource getObservationUnitListResource() {
		return getResource(ObservationUnitListResource.class);
	}
	
	@Path("/aoi-hierarchies")
	public AoiHierarchyListResource getAoiHierarchyListResource(){
		return getResource(AoiHierarchyListResource.class);
	}

	Survey getSurvey() {
		Survey survey = surveyDao.findByName(getKey());
		if ( survey == null ) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return survey;
	}

	int getSurveyId() {
		Survey survey = getSurvey();
		return survey.getId();
	}
}
