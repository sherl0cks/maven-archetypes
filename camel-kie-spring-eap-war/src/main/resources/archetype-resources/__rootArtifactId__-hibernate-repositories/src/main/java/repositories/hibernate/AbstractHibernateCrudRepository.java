#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repositories.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import ${package}.aggregates.AggregateRoot;
import ${package}.repositories.api.CRUDRepository;

public abstract class AbstractHibernateCrudRepository< T extends AggregateRoot > implements CRUDRepository< T > {

	protected SessionFactory	sessionFactory;

	@Override
	public T saveOrUpdate( T aggregate ) {
		sessionFactory.getCurrentSession().saveOrUpdate( aggregate );
		return aggregate;
	}

	@SuppressWarnings( { "unchecked" } )
	@Override
	public T retrieveById( Class< ? > clazz, Long id ) {
		return ( T ) sessionFactory.getCurrentSession().get( clazz, id );
	}

	@Override
	public void delete( T aggregate ) {
		sessionFactory.getCurrentSession().delete( aggregate );
	}

	@Override
	public int size( Class< ? > clazz ) {
		Long size = ( Long ) sessionFactory.getCurrentSession().createCriteria( clazz ).setProjection( Projections.rowCount() ).uniqueResult();
		return size.intValue();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory( SessionFactory sessionFactory ) {
		this.sessionFactory = sessionFactory;
	}

}
