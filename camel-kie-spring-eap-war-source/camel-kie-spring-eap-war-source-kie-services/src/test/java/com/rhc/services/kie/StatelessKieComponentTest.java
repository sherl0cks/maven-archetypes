package com.rhc.services.kie;

import org.junit.Assert;
import org.junit.Test;

import com.rhc.test.support.AbstractKieSpringTestSupport;

public class StatelessKieComponentTest extends AbstractKieSpringTestSupport {

	@Test
	public void shouldLoadAKnowledgeSessionOnCreation() {
		Assert.assertNotNull( kie );
		Assert.assertNotNull( kie.getKieContainer() );
	}


}
