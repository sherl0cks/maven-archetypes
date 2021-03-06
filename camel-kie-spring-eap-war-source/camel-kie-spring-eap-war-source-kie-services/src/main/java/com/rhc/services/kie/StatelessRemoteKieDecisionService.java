package com.rhc.services.kie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.command.BatchExecutionCommand;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;
import org.kie.api.runtime.ExecutionResults;
import org.kie.internal.runtime.helper.BatchExecutionHelper;
import org.kie.server.api.model.ServiceResponse;
import org.kie.server.api.model.ServiceResponse.ResponseType;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rhc.kie.component.QueryUtils;
import com.rhc.kie.component.ReflectiveExecutionResultsTransformer;
import com.rhc.services.api.StatelessDecisionService;
import com.thoughtworks.xstream.XStream;

public class StatelessRemoteKieDecisionService implements StatelessDecisionService {

	private static final Logger LOGGER = LoggerFactory.getLogger(StatelessRemoteKieDecisionService.class);

	private String httpUrl;
	private String containerId;

	private KieCommands commandFactory;
	private KieServicesClient client;
	private XStream xstream;

	public StatelessRemoteKieDecisionService(String httpUrl, String userName, String password, int timeout, String containerId) {
		KieServicesConfiguration config;
		if (timeout == 0) {
			config = KieServicesFactory.newRestConfiguration(httpUrl, userName, password);
		} else {
			config = KieServicesFactory.newRestConfiguration(httpUrl, userName, password, 0);
		}
		this.client = KieServicesFactory.newKieServicesClient(config);
		this.containerId = containerId;
		this.httpUrl = httpUrl;
		commandFactory = KieServices.Factory.get().getCommands();
		xstream = BatchExecutionHelper.newXStreamMarshaller();
	}

	@Override
	public <Response> Response execute(Collection<Object> facts, String processId, Class<Response> responseClazz, String logName) {
		BatchExecutionCommand batchExecutionCommand = createBatchExecutionCommand(facts, processId, responseClazz);

		String payload = xstream.toXML(batchExecutionCommand);

		LOGGER.info(String.format("Remote BRMS request to %s/%s with below payload: \n %s",  httpUrl , containerId, payload));

		ServiceResponse<String> reply = client.executeCommands(containerId, payload);
		if (reply.getType().equals(ResponseType.FAILURE)) {
			LOGGER.error(reply.toString());
			throw new RuntimeException(reply.getMsg());
		}

		LOGGER.info(reply.getResult());

		ExecutionResults results = (ExecutionResults) xstream.fromXML(reply.getResult());

		Response response = ReflectiveExecutionResultsTransformer.transform(results, responseClazz);

		return response;
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

		return commandFactory.newBatchExecution(commands, "defaultStatelessKieSession");
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

	@Override
	public boolean upgradeRulesToVersion(String group, String artifact, String version) {
		return false;
	}

}
