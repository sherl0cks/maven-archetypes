#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.util.ArrayList;
import java.util.Collection;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import ${package}.aggregates.Customer;
import ${package}.kie.component.KieResponse;

public class BusinessRulesAggregationStrategy implements AggregationStrategy {

	@Override
	public Exchange aggregate( Exchange oldExchange, Exchange newExchange ) {
		if ( newExchange == null ) {
			return oldExchange;
		}

		Customer customer = oldExchange.getIn().getBody( Customer.class );
		KieResponse response = newExchange.getIn().getBody( KieResponse.class );

		updateWithFiredRules( customer, response );

		Collection< Object > outboundBody = new ArrayList< Object >();

		outboundBody.add( "" );

		oldExchange.getIn().setBody( outboundBody );

		return oldExchange;
	}

	private void updateWithFiredRules( Customer customer, KieResponse response ) {
		if ( response.getRuleListener() != null && response.getRuleListener().getRuleFiredEvents().size() > 0 ) {
			
		}

	}

}
