#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.transactions;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.SimpleTransactionStatus;

/**
 * 
 * This is a basic mock trx manager to support mock repositories in camel tests
 *
 */
public class MockSpringTransactionManager implements PlatformTransactionManager {

	@Override
	public TransactionStatus getTransaction( TransactionDefinition definition ) throws TransactionException {
		return new SimpleTransactionStatus();
	}

	@Override
	public void commit( TransactionStatus status ) throws TransactionException {

	}

	@Override
	public void rollback( TransactionStatus status ) throws TransactionException {
		
	}

}
