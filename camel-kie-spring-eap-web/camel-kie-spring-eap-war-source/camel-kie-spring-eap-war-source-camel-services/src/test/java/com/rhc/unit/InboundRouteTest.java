package com.rhc.unit;

import org.apache.camel.component.mock.MockEndpoint;
import org.junit.Assert;
import org.junit.Test;

import com.rhc.aggregates.Customer;
import com.rhc.repositories.api.CustomerStageRepository;
import com.rhc.support.AbstractCamelSpringUnitTestSupport;

public class InboundRouteTest extends AbstractCamelSpringUnitTestSupport {

	@Test
	public void shouldReceiveTestCustomerAndSendToBusinessRules() throws InterruptedException {
		// given
		Customer customer = new Customer();
		CustomerStageRepository customerStageRepository = applicationContext.getBean(CustomerStageRepository.class);
		Assert.assertEquals( 0, customerStageRepository.size(Customer.class));
		
		MockEndpoint toBusinessRules = getMockEndpoint("mock:BusinessRules");
		toBusinessRules.expectedMessageCount(1);

		// when
		template.sendBody("jms:INBOUND_QUEUE", customer);

		// then
		assertMockEndpointsSatisfied();
		Assert.assertNotNull(toBusinessRules.getExchanges().get(0).getIn().getBody());
		
		// do these assertions after the exchanges have arrived
		Assert.assertEquals(1, customerStageRepository.size(Customer.class));
	}
}
