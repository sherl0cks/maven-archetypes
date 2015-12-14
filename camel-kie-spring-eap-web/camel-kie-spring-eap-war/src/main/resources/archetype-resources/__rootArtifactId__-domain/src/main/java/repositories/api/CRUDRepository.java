#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repositories.api;

import ${package}.aggregates.AggregateRoot;

public interface CRUDRepository< Aggregate extends AggregateRoot > {

	public Aggregate saveOrUpdate( Aggregate aggregate );

	public Aggregate retrieveById( Class< ? > clazz, Long id );

	public void delete( Aggregate aggregate );

	public int size( Class< ? > clazz );
}
