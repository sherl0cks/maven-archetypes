set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.entities;


/**
 * 
 * This interface should be implemented by all classes that serve as Entities in
 * the domain model. This ID should also serve as the ID for JPA/Hibernate
 * implementations
 * 
 * @see http://martinfowler.com/bliki/EvansClassification.html
 * 
 */
public interface Entity {

	public Long getId();

	public void setId( Long id );
}
