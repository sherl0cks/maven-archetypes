package com.rhc.services.kie;

import org.junit.Assert;
import org.junit.Test;

import com.rhc.kie.component.KieResponse;
import com.rhc.test.support.AbstractKieSpringTestSupport;

public class StatelessKieComponentTest extends AbstractKieSpringTestSupport {

	@Test
	public void shouldLoadAKnowledgeSessionOnCreation() {
		Assert.assertNotNull( kie );
		Assert.assertNotNull( kie.getKieContainer() );
	}

	@Test
	public void shouldSucceedToUpgradeRules(){
		Assert.assertTrue( kie.upgradeRulesToVersion("com.rhc", "camel-kie-spring-eap-war-source-business-rules", "1.0-SNAPSHOT") );
		KieResponse response = kie.execute( null, ProcessIds.RULEFLOW, KieResponse.class );
		Assert.assertNotNull( response );
	}
	
	@Test
	public void shouldFailToUpgradeRules(){
		Assert.assertFalse( kie.upgradeRulesToVersion("this", "will", "fail") );
		KieResponse response = kie.execute( null, ProcessIds.RULEFLOW, KieResponse.class );
		Assert.assertNotNull( response );
	}

}
