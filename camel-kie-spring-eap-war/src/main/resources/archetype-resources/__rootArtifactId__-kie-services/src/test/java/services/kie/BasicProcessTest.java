#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.services.kie;

import org.junit.Assert;
import org.junit.Test;

import ${package}.kie.component.EciKieResponse;
import ${package}.test.support.AbstractKieSpringTestSupport;

public class BasicProcessTest extends AbstractKieSpringTestSupport {

	
	@Test
	public void shouldExecuteRuleflowProcess() {
		KieResponse response = kie.execute( null, ProcessIds.RULEFLOW, KieResponse.class );
		Assert.assertNotNull( response );
	}
}
