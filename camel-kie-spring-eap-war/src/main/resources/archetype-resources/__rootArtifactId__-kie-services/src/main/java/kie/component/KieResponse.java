#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.kie.component;

import java.util.Collection;

import ${package}.entities.Discount;
import ${package}.kie.component.KieQuery;
import ${package}.services.kie.RuleListener;

import ${package}.services.kie.RuleListener;

public class KieResponse {

	@KieQuery(queryName = "Get Discounts", binding = "$discount")
	private Collection<Discount> discount;

	private RuleListener ruleListener;

	public Collection<Discount> getDiscount() {
		return discount;
	}

	public void setDiscount(Collection<Discount> discount) {
		this.discount = discount;
	}

	public RuleListener getRuleListener() {
		return ruleListener;
	}

	public void setRuleListener(RuleListener ruleListener) {
		this.ruleListener = ruleListener;
	}
	
}
