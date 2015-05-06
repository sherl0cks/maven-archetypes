package com.rhc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.rhc.aggregates.Customer;
import com.rhc.kie.component.KieResponse;
import com.rhc.services.api.StatelessDecisionService;
import com.rhc.services.kie.ProcessIds;

public class StatelessDecisionServiceCamelAdapter {

	private StatelessDecisionService	statelessDecisionService;
	
	public Object executeRuleflow( Customer customer ) throws SQLException {

		Collection< Object > facts = customer.asCollectionOfFacts();

		return statelessDecisionService.execute( facts, ProcessIds.RULEFLOW, KieResponse.class );
	}


	public StatelessDecisionService getStatelessDecisionService() {
		return statelessDecisionService;
	}

	public void setStatelessDecisionService( StatelessDecisionService statelessDecisionService ) {
		this.statelessDecisionService = statelessDecisionService;
	}

}
