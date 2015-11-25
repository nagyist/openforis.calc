package org.openforis.calc.persistence;

import static org.openforis.calc.persistence.jooq.Tables.OBSERVATION_UNIT;
import static org.openforis.calc.persistence.jooq.Tables.TAXONOMIC_CHECKLIST;

import java.util.List;

import org.jooq.Select;
import org.jooq.impl.Factory;
import org.openforis.calc.model.TaxonomicChecklist;
import org.openforis.calc.persistence.jooq.JooqDaoSupport;
import org.openforis.calc.persistence.jooq.tables.ObservationUnit;
import org.openforis.calc.persistence.jooq.tables.records.TaxonomicChecklistRecord;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author M. Togna
 */
@Component
@Transactional
public class TaxonomicChecklistDao extends JooqDaoSupport<TaxonomicChecklistRecord, TaxonomicChecklist> {

	public TaxonomicChecklistDao() {
		super(TAXONOMIC_CHECKLIST, TaxonomicChecklist.class, TAXONOMIC_CHECKLIST.CHECKLIST_NAME);
	}

	public List<TaxonomicChecklist> findBySurveyId(int surveyId) {
		ObservationUnit obsUnit = OBSERVATION_UNIT.as("o");
		org.openforis.calc.persistence.jooq.tables.TaxonomicChecklist taxonomicChecklist = TAXONOMIC_CHECKLIST.as("t");
		
		Factory create = getJooqFactory();
		
		Select<?> selectCheckListIds = 
				create
					.selectDistinct( obsUnit.TAXONOMIC_CHECKLIST_ID )
					.from( obsUnit )
					.where( obsUnit.SURVEY_ID.eq(surveyId) );
		
		Select<?> selectTaxonomicChecklist = 
				create
					.select()		
					.from( taxonomicChecklist )
					.where( 
							taxonomicChecklist.CHECKLIST_ID.in( selectCheckListIds )
						);
		
		List<TaxonomicChecklist> result = selectTaxonomicChecklist.fetch().into(getType());
		
		return result;
	}

}