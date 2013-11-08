package org.openforis.calc.server.rest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.openforis.calc.service.ObservationService;
import org.openforis.commons.io.flat.FlatDataStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author G. Miceli
 * @author M. Togna
 */
@Component
@Lazy
@Scope("request")
public class SpecimenListResource extends SubResource<Void> {

	@Autowired
	private ObservationUnitResource observationUnitResource;
	@Autowired
	private ObservationService observationService;
	@Autowired
	private SurveyResource surveyResource;

	@GET
	public FlatDataStream getList() {
		String observationUnitName = observationUnitResource.getKey();
		String surveyName = surveyResource.getKey();

		return observationService.getSpecimenDataStream(surveyName, observationUnitName, getFields());
	}

	@PATCH
	
	public Response update(FlatDataStream dataStream) throws URISyntaxException, IOException {
		List<String> varNames = dataStream.getFieldNames();

		observationService.updateSpecimenValues(surveyResource.getKey(), observationUnitResource.getKey(), dataStream, varNames);

		// Use OK response instead of created; HTTP PATCH may create or update
		return Response.ok(new URI("specimens")).entity("OK").build();
	}

	@PATCH
	@Path("/inclusion-area")
	public Response updateSpecimenInlcusionArea(FlatDataStream dataStream) throws Exception {

		observationService.updateSpecimenInlcusionArea(dataStream);

		return Response.ok( new URI("inclusion-area") ).entity("OK").build();
	}

}