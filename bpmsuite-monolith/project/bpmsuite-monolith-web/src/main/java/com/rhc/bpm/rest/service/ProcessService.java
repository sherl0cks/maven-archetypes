package com.rhc.bpm.rest.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.rhc.aggregates.Customer;

public interface ProcessService {


	/**
	 * Starts process
	 */
	@POST
	@Path("startprocess")
	@Produces("text/plain")
	public Long startProcess( @QueryParam("processId") String processName, @QueryParam("groupId") String groupId,
			@QueryParam("artifactId") String artificatId,@QueryParam("version")String version, Customer customer);
}
