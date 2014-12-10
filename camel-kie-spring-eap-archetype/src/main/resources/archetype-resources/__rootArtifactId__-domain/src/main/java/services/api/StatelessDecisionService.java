#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.services.api;

import java.util.Collection;

public interface StatelessDecisionService {
	
	public < Response > Response execute( Collection<Object> facts, String processId, Class< Response > responseClazz, String logName );

	public < Response > Response execute( Collection<Object> facts, String processId, Class< Response > responseClazz );
	
	public < Response > Response execute( Collection<Object> facts, String processId, String logName );
	
	public < Response > Response execute( Collection<Object> facts, Class< Response > responseClazz );

}