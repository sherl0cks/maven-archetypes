package com.rhc.services.kie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.command.BatchExecutionCommand;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;

import com.rhc.kie.component.QueryUtils;
import com.rhc.services.api.StatelessDecisionService;

public class StatelessRemoteKieDecisionService implements StatelessDecisionService {

	private String httpUrl;
	private String userName;
	private String password;
	private int timeout = 0;
	
	private KieCommands commandFactory;
	private KieServicesClient client;
	
	public StatelessRemoteKieDecisionService() {
		KieServicesConfiguration config;
		if ( timeout == 0 ){
			config = KieServicesFactory.newRestConfiguration(httpUrl, userName, password);
		} else {
			config = KieServicesFactory.newRestConfiguration(httpUrl, userName, password, 0);
		}
		this.client = KieServicesFactory.newKieServicesClient(config);
		commandFactory = KieServices.Factory.get().getCommands();
	}
	
	@Override
	public <Response> Response execute(Collection<Object> facts, String processId, Class<Response> responseClazz, String logName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public BatchExecutionCommand createBatchExecutionCommand(Collection<Object> facts, String processId, Class<?> responseClazz) {
		List<Command<?>> commands = new ArrayList<Command<?>>();

		if (facts != null) {
			commands.add(commandFactory.newInsertElements(facts));
		}
		if (processId != null && !processId.isEmpty()) {
			commands.add(commandFactory.newStartProcess(processId));
		}

		commands.add(commandFactory.newFireAllRules());

		// creates commands to run the queries at the end of process
		commands.addAll(QueryUtils.buildQueryCommands(responseClazz));

		return commandFactory.newBatchExecution(commands);
	}

	@Override
	public <Response> Response execute(Collection<Object> facts, String processId, Class<Response> responseClazz) {
		return execute(facts, processId, responseClazz, null);
	}

	@Override
	public <Response> Response execute(Collection<Object> facts, String processId, String logName) {
		return execute(facts, processId, null, logName);
	}

	@Override
	public <Response> Response execute(Collection<Object> facts, Class<Response> responseClazz) {
		return execute(facts, null, responseClazz, null);
	}

}
