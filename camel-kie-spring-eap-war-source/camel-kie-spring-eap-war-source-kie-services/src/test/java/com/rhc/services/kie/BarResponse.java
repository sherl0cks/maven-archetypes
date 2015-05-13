package com.rhc.services.kie;

import java.util.Collection;

import org.kie.example.project1.Bar;

import com.rhc.kie.component.KieQuery;

public class BarResponse {

	@KieQuery(binding = "$bar", queryName = "Ger Bars")
	private Collection<Bar> bars;

	public Collection<Bar> getBars() {
		return bars;
	}

	public void setBars(Collection<Bar> bars) {
		this.bars = bars;
	}

	@Override
	public String toString() {
		return "BarResponse [bars=" + bars + "]";
	}

}
