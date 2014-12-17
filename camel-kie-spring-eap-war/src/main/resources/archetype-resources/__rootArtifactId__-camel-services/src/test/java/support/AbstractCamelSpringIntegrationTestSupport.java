#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.support;

import java.io.IOException;

import org.apache.camel.CamelContext;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.TransactionStatus;

import ${package}.test.support.DatabaseUtils;

public abstract class AbstractCamelSpringIntegrationTestSupport extends AbstractCamelSpringTestSupport {

	protected HibernateTransactionManager	txm;
	public DatabaseUtils					dbUtils;

	@Override
	public String[] activeProfiles() {
		String[] profiles = { "test", "integration" };
		return profiles;
	}

	@Override
	public CamelContext createCamelContext() throws Exception {
		CamelContext camelContext = super.createCamelContext();

		txm = ( HibernateTransactionManager ) applicationContext.getBean( "jtaTxManager" );
		dbUtils = applicationContext.getBean( DatabaseUtils.class );

		return camelContext;
	}

	// TODO get Camel and Spring Autowired setup correctly
	protected void setup() throws IllegalStateException, IOException {
		TransactionStatus status = txm.getTransaction( null );
		dbUtils.clearDatabase();
		txm.commit( status );
	}
}
