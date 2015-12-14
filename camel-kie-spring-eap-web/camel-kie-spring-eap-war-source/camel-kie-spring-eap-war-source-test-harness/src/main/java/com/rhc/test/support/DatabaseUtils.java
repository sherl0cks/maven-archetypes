package com.rhc.test.support;


import org.hibernate.SessionFactory;



// TODO update me with the new aggregate
public class DatabaseUtils {

	private SessionFactory	sessionFactory;

	public void clearDatabase() {
		throw new RuntimeException( "Update me to delete aggregates in DB");
		
		//sessionFactory.getCurrentSession().flush();
	}


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory( SessionFactory sessionFactory ) {
		this.sessionFactory = sessionFactory;
	}

}
