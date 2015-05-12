package com.rhc.kie.component;

import java.util.Collection;

import com.rhc.entities.Discount;
import com.rhc.services.kie.RuleListener;

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
