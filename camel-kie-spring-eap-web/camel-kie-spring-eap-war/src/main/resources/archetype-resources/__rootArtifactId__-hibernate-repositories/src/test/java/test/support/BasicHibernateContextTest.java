#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.test.support;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTransactionManager;

/**
*
* This class should be unignored when you add an Oracle datasource
*/
@Ignore
public class BasicHibernateContextTest extends AbstractHibernateOracleSpringTestSupport {

	@Autowired
	private DataSource					dataSource;
	@Autowired
	private SessionFactory				sessionFactory;
	@Autowired
	private HibernateTransactionManager	transactionManager;

	@Test
	public void shouldCreateAnOracleDatasourceWithAValidConnection() throws SQLException {
		Assert.assertNotNull( dataSource );
		Assert.assertNotNull( dataSource.getConnection() );
	}

	@Test
	public void shouldCreateHibernateSessionFactory() {
		Assert.assertNotNull( sessionFactory );
	}

	@Test
	public void shouldCreateTransactionManagerThatManagesHibernateSessions() {
		Assert.assertNotNull( transactionManager );
		Assert.assertNotNull( sessionFactory.getCurrentSession() );
	}

}
