#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import ${package}.aggregates.Customer;
import ${package}.kie.component.KieResponse;
import ${package}.services.api.StatelessDecisionService;
import ${package}.services.kie.ProcessIds;

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
