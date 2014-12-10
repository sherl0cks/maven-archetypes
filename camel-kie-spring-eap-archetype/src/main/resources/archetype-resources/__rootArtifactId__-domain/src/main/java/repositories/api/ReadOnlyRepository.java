#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repositories.api;


public interface ReadOnlyRepository< T > {

	public T getValueObject();

}
