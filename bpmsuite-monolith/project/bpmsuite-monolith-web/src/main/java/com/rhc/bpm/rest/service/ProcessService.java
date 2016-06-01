package com.rhc.bpm.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

public interface ProcessService {

	/**
	 * Starts process
	 */
	@GET
	@Path("startprocess")
	@Produces("text/plain")
	public String startProcess(@QueryParam("processName")String processName);
}
