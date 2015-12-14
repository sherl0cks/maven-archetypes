#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.apache.camel.spring.spi.BridgePropertyPlaceholderConfigurer;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@Profile( value = { "test" } )
@ContextConfiguration( locations = { "classpath:properties-context.xml" } )
public class PropertiesTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private BridgePropertyPlaceholderConfigurer	properties;

	@Test
	public void shouldCreateAPropertiesComponent() {
		Assert.assertNotNull( properties );
	}

}