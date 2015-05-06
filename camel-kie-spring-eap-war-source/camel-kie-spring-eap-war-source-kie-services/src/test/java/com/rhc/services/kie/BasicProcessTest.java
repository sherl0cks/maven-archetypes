package com.rhc.services.kie;

import org.junit.Assert;
import org.junit.Test;

import com.rhc.kie.component.KieResponse;
import com.rhc.test.support.AbstractKieSpringTestSupport;

public class BasicProcessTest extends AbstractKieSpringTestSupport {

	
	@Test
	public void shouldExecuteRuleflowProcess() {
		KieResponse response = kie.execute( null, ProcessIds.RULEFLOW, KieResponse.class );
		Assert.assertNotNull( response );
	}
}
