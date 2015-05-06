package com.rhc.repositories.hibernate;

import org.hibernate.SessionFactory;

import com.rhc.repositories.api.ReadOnlyRepository;

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
