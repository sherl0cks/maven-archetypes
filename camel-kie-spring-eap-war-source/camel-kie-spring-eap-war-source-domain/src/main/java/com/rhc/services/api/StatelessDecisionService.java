package com.rhc.services.api;

import java.util.Collection;

public interface StatelessDecisionService {
	
	public < Response > Response execute( Collection<Object> facts, String processId, Class< Response > responseClazz, String logName );

	public < Response > Response execute( Collection<Object> facts, String processId, Class< Response > responseClazz );
	
	public < Response > Response execute( Collection<Object> facts, String processId, String logName );
	
	public < Response > Response execute( Collection<Object> facts, Class< Response > responseClazz );

}