#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.kie.component;

import java.util.Collection;

import ${package}.entities.IncomingMessageStatuses;
import ${package}.entities.Message;
import ${package}.marker.CancelMessageMarker;
import ${package}.marker.TransactionMarker;
import ${package}.services.kie.KieEnrichmentListener;

public class KieResponse {

	// TODO provide support for an idividual attribute in Kie Query

	@KieQuery( queryName = "Get Strings" , binding = "${symbol_dollar}string" )
	private Collection< String >					strings;

	private RuleListener					ruleListener;

	public Collection< String > getStrings() {
		return strings;
	}

	public void setStrings Collection< String > strings ) {
		this.strings = strings;
	}

	public RuleListener getRuleListener() {
		return ruleListener;
	}

	public void setRuleListener( RuleListener ruleListener ) {
		this.ruleListener = ruleListener;
	}
}
