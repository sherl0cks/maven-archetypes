#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.services.kie;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import ${package}.kie.component.EciKieResponse;
import ${package}.test.support.AbstractKieSpringTestSupport;

public class StatelessKieComponentTest extends AbstractKieSpringTestSupport {

	@Test
	public void shouldLoadAKnowledgeSessionOnCreation() {
		Assert.assertNotNull( kie );
		Assert.assertNotNull( kie.getKieContainer() );
	}


}
