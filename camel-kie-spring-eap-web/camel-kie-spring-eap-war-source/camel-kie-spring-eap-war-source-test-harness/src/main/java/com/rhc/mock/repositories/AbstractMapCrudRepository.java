package com.rhc.mock.repositories;


import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rhc.aggregates.AggregateRoot;
import com.rhc.repositories.api.CRUDRepository;

public class AbstractMapCrudRepository< T extends AggregateRoot > implements CRUDRepository< T > {

	private static final Logger	LOG		= LoggerFactory.getLogger( AbstractMapCrudRepository.class );

	protected static Long		uuid	= new Long( 0 );

	protected Map< Long, T >	map		= new HashMap< Long, T >();

	@Override
	public T saveOrUpdate( T aggregate ) {
		if ( aggregate.getId() == null ) {
			aggregate.setId( ++uuid );
			LOG.debug( String.format( "saveOrUpdate uuid was null - setting it to %s", uuid ) );
		}
		else {
			LOG.debug( String.format( "saveOrUpdate uuid: %s", uuid ) );
		}
		map.put( aggregate.getId(), aggregate );
		return aggregate;
	}

	@Override
	public T retrieveById( Class< ? > clazz, Long id ) {
		if ( id == null ) {
			LOG.debug( String.format( "id is null - this is bad" ) );
		}
		LOG.debug( String.format( "retrieivng uuid %s", id ) );
		return map.get( id );
	}


	@Override
	public void delete( T aggregate ) {
		map.remove( aggregate.getId() );
	}

	@Override
	public int size( Class< ? > clazz ) {
		return map.size();
	}

}