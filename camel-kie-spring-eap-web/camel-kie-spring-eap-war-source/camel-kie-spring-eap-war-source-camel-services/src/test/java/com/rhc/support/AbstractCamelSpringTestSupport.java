package com.rhc.support;

import org.apache.camel.CamelContext;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public abstract class AbstractCamelSpringTestSupport extends CamelSpringTestSupport {

	@Override
	public AbstractXmlApplicationContext createApplicationContext() {
		String[] locations = { "camel-context.xml" };
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( locations, false );

		return context;
	}

	@Override
	protected int getShutdownTimeout() {
		return 1;
	}

	@Override
	public String isMockEndpoints() {
		return "*";
	}

	@Override
	public CamelContext createCamelContext() throws Exception {
		CamelContext camelContext = super.createCamelContext();

		return camelContext;
	}
}
