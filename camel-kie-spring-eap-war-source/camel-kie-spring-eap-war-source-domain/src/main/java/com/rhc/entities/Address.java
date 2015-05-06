package com.rhc.entities;

import com.rhc.vo.State;

public class Address implements Entity {

	private Long id;

	private State state;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
