package com.rhc.bpm;

import org.junit.Assert;
import org.junit.Test;

public class BpmRuntimeConfigurationTest extends AbstractBpmRuntimeTest {

	@Test
	public void shouldCreateBpmServices(){
		Assert.assertNotNull( deploymentService );
		Assert.assertNotNull( userTaskService );
		Assert.assertNotNull( processService );
		Assert.assertNotNull( runtimeDataService );
	}
}
