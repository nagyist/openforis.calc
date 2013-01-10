package org.openforis.calc.service;

import java.io.IOException;

import org.openforis.calc.io.csv.CsvReader;
import org.openforis.calc.io.flat.FlatDataStream;
import org.openforis.calc.io.flat.FlatRecord;
import org.openforis.calc.model.ObservationUnit;
import org.openforis.calc.persistence.PlotSectionViewDao;
import org.openforis.calc.persistence.SpecimenCategoricalValueDao;
import org.openforis.calc.persistence.SpecimenDao;
import org.openforis.calc.persistence.SpecimenNumericValueDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
/**
 * 
 * @author G. Miceli
 *
 */
@Component
public class ObservationService {

	@Autowired 
	private MetadataService metadataService;
	@Autowired
	private PlotSectionViewDao plotSectionViewDao;
	@Autowired
	private SpecimenDao specimenDao;
	@Autowired
	private SpecimenNumericValueDao specimenMeasurementDao;
	@Autowired
	private SpecimenCategoricalValueDao specimenCategoryDao;

	@Autowired
	@Value("#{calc.dev.test-data-path}")
	private String testTreesFilename;
	
	public static void main(String[] args)  {
		try {
			ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			ObservationService svc = ctx.getBean(ObservationService.class);
			svc.test();
		} catch ( Throwable ex ) {
			ex.printStackTrace();
		}
	}
	
	private void test() throws IOException {
		CsvReader in = new CsvReader(testTreesFilename+"/trees.csv");
		in.readHeaders();
		importSpecimenData("naforma1", "tree", in);
	}

	public void importSpecimenData(String surveyName, String observationUnit, FlatDataStream in) throws IOException {
		ObservationUnit specimenUnit = metadataService.getObservationUnit(surveyName, observationUnit);
		if ( specimenUnit == null ) {
			throw new IllegalArgumentException("Invalid survey or observation unit");
		}
		if ( !"specimen".equals(specimenUnit.getObsUnitType()) ) {
			throw new IllegalArgumentException("Invalid observation unit type: "+specimenUnit.getObsUnitType()); 
		}
		ObservationUnit plotUnit = metadataService.getObservationUnit(surveyName, "plot");		// TODO <<< implement getParent
		int plotUnitId = plotUnit.getId();
		FlatRecord r;
		while ( (r = in.nextRecord()) != null ) {
			Integer plotSectionId = plotSectionViewDao.getId(plotUnitId, r);			
			System.out.println(plotSectionId);
		}
	}
}
