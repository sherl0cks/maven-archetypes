#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.test.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import ${package}.services.kie.StatelessKieDecisionService;

@ActiveProfiles( profiles = { "test" } )
@ContextConfiguration( locations = { "classpath:kie-context.xml" } )
public abstract class AbstractKieSpringTestSupport extends AbstractJUnit4SpringContextTests {

	@Autowired
	protected StatelessKieDecisionService	kie;
}
