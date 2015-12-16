package com.rhc.bpm;

import org.jbpm.services.api.DeploymentService;
import org.jbpm.services.api.ProcessService;
import org.jbpm.services.api.RuntimeDataService;
import org.jbpm.services.api.UserTaskService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.rhc.utils.TestUtils;

import bitronix.tm.resource.jdbc.PoolingDataSource;

@ContextConfiguration(locations = { "classpath:bpm-runtime-context.xml" })
@ActiveProfiles("test")
public abstract class AbstractBpmRuntimeTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	protected ProcessService processService;
	@Autowired
	protected RuntimeDataService runtimeDataService;
	@Autowired
	protected DeploymentService deploymentService;
	@Autowired
	protected UserTaskService userTaskService;

	protected static PoolingDataSource pds;

	@BeforeClass
	public static void generalSetup() {
		TestUtils.setupPoolingDataSource();
	}

	@Before
	public void setup() {
		TestUtils.cleanupSingletonSessionId();

	}
}
