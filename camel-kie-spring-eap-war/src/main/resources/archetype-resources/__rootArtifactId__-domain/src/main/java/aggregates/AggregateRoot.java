#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.aggregates;

import java.util.Collection;

import ${package}.entities.Entity;

/**
 * 
 * This interface is used to mark classes that serve as aggregate roots in the domain model. All classes implementing this interface should have an associated repository.
 * 
 * @see http://devlicio.us/blogs/casey/archive/2009/02/16/ddd-aggregates-and-aggregate-roots.aspx
 * 
 */
public interface AggregateRoot extends Entity {

	/**
	 * 
	 * Aggregates are the boundaries by which we design decision services. This method provides a flat representation of the Aggregate for easier business rules authoring
	 */
	public Collection<Object> asCollectionOfFacts();

	
}