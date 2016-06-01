package com.rhc.bpm.rest.service.impl;

import org.jbpm.services.api.DeploymentService;
import org.jbpm.services.api.RuntimeDataService;
import org.jbpm.services.api.UserTaskService;

import com.rhc.aggregates.Customer;
import com.rhc.bpm.rest.service.ProcessService;

public class ProcessServiceImpl implements ProcessService {
	private ProcessService processService;
	private RuntimeDataService runtimeDataService;
	private DeploymentService deploymentService;
	private UserTaskService userTaskService;
	@Override
	public Long startProcess(String processName, String groupId, String artificatId, String version,
			Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
