package com.rhc.test.support;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;

import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Assert;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.TransactionStatus;


public abstract class AbstractCamelSpringTestSupport extends CamelSpringTestSupport {

	public HibernateTransactionManager	txm;
	public DatabaseUtils				dbUtils;

	@Override
	public AbstractXmlApplicationContext createApplicationContext() {
		String[] locations = { "test-camel-context.xml" };
		return new ClassPathXmlApplicationContext( locations, false );
	}

	@Override
	public String isMockEndpoints() {
		return "*";
	}

	@Override
	public String[] activeProfiles() {
		String[] profiles = { "test" };
		return profiles;
	}
}
