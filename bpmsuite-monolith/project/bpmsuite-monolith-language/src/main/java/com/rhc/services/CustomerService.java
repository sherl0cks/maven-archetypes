package com.rhc.services;

public interface CustomerService {

	public Long startCustomerOnboardProcess( String firstName, String lastName );
	
	public int getNumberOfCustomerOnboardProcessesInProgress();
}
