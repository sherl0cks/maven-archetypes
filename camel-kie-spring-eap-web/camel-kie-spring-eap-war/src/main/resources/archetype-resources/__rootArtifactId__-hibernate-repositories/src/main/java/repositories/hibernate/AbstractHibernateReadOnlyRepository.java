#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repositories.hibernate;

import org.hibernate.SessionFactory;

import ${package}.repositories.api.ReadOnlyRepository;

public class AbstractHibernateReadOnlyRepository< T > implements ReadOnlyRepository< T > {

	protected SessionFactory	sessionFactory;

	@Override
	public T getValueObject() {
		// TODO modify to use session factory
		return null;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory( SessionFactory sessionFactory ) {
		this.sessionFactory = sessionFactory;
	}

}
