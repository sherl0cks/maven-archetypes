package com.rhc.services;

import com.rhc.aggregates.Customer;

public interface CustomerService {

	public Long startCustomerOnboardProcess( Customer customer );
	
	public int getNumberOfCustomerOnboardProcessesInProgress();
}
