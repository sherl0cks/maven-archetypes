package com.rhc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import com.rhc.bpm.AbstractBpmRuntimeTest;

@ContextConfiguration(locations = { "classpath:business-services-context.xml" })
@ActiveProfiles("test")
public abstract class AbstractBusinessServicesTest extends AbstractBpmRuntimeTest {

	@Autowired
	protected CustomerService customerService;
}
