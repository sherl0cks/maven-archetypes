package com.rhc.customer;

import org.junit.Assert;
import org.junit.Test;

import com.rhc.services.AbstractBusinessServicesTest;

public class CustomerServiceTest extends AbstractBusinessServicesTest{
	
	@Test
	public void shouldSuccessfullyStartACustomerOnboardProcess(){
		// given
		Assert.assertNotNull(customerService);
		
		// when 
		Long processId = customerService.startCustomerOnboardProcess("Leia", "Organa");
		
		// then
		Assert.assertEquals( new Long(1), processId);
		Assert.assertEquals( 1, customerService.getNumberOfCustomerOnboardProcessesInProgress());
	}
	
}
