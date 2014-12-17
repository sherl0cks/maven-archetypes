#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.support;

import org.apache.camel.CamelContext;

public abstract class AbstractCamelSpringUnitTestSupport extends AbstractCamelSpringTestSupport {

	@Override
	public String[] activeProfiles() {
		String[] profiles = { "test" };
		return profiles;
	}

	@Override
	public CamelContext createCamelContext() throws Exception {
		CamelContext camelContext = super.createCamelContext();
		camelContext.addComponent( "jms", camelContext.getComponent( "seda" ) );

		return camelContext;
	}

}
