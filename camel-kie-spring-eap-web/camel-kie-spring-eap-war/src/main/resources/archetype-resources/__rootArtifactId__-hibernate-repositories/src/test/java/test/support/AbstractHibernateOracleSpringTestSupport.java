#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.test.support;

import javax.annotation.Resource;

import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ActiveProfiles( profiles = { "test" } )
@ContextConfiguration( locations = { "classpath:oracle-context.xml" } )
public abstract class AbstractHibernateOracleSpringTestSupport extends AbstractTransactionalJUnit4SpringContextTests {

	@Resource( name = "jtaTxManager" )
	protected HibernateTransactionManager	oracleTxManager;

	@Autowired
	protected DatabaseUtils databaseUtils;
	// Hack to get around the spring context loading after @BeforeClass
	@After
	public void setup() {

		//DatabaseUtils.clearTables( oracleTxManager );

	}
}