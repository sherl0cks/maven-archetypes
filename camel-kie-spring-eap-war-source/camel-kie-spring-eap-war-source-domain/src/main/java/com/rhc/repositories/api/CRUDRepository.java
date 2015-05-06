package com.rhc.repositories.api;

import com.rhc.aggregates.AggregateRoot;

public interface CRUDRepository< Aggregate extends AggregateRoot > {

	public Aggregate saveOrUpdate( Aggregate aggregate );

	public Aggregate retrieveById( Class< ? > clazz, Long id );

	public void delete( Aggregate aggregate );

	public int size( Class< ? > clazz );
}
