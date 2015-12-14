package com.rhc.entities;

import java.util.List;

public class Discount implements Entity {

	private Long id;

	private Long dollarAmount;

	private List<String> firedRules;
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Long getDollarAmount() {
		return dollarAmount;
	}

	public void setDollarAmount(Long dollarAmount) {
		this.dollarAmount = dollarAmount;
	}
	
	public List<String> getFiredRules() {
		return firedRules;
	}

	public void setFiredRules(List<String> firedRules) {
		this.firedRules = firedRules;
	}

}
