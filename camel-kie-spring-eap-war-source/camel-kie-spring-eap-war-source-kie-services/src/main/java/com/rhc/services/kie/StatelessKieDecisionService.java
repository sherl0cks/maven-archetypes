package com.rhc.services.kie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.drools.compiler.kproject.ReleaseIdImpl;
import org.kie.api.KieServices;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.ReleaseId;
import org.kie.api.builder.Results;
import org.kie.api.command.BatchExecutionCommand;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.ExecutionResults;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rhc.kie.component.KieResponse;
import com.rhc.kie.component.QueryUtils;
import com.rhc.kie.component.ReflectiveExecutionResultsTransformer;
import com.rhc.services.api.StatelessDecisionService;

public class StatelessKieDecisionService implements StatelessDecisionService {

	private static final Logger LOGGER = LoggerFactory.getLogger(StatelessKieDecisionService.class);

	private KieCommands commandFactory;
	private KieContainer kieContainer;
	private boolean ruleListenerActive;
	private boolean debugLogging;

	public StatelessKieDecisionService() {
		kieContainer = KieServices.Factory.get().getKieClasspathContainer();
		try {
			StatelessKieSession statelessKieSession = kieContainer.newStatelessKieSession();
			LOGGER.debug(statelessKieSession.getKieBase().toString());
		} catch (Exception e) {
			LOGGER.warn("There is no KieModule on the classpath. Upgrade the KieContainer to a valid KieModule to fire rules");
		}

		/**
		 * Break point here to find what rules are in the KIE Base
		 */
		commandFactory = KieServices.Factory.get().getCommands();
	}

	@Override
	public <Response> Response execute(Collection<Object> facts, String processId, Class<Response> responseClazz, String logName) {
		StatelessKieSession session;
		try {
			session = kieContainer.newStatelessKieSession();
		} catch (Exception e) {
			LOGGER.error("The KieContainer is empty; Upgrade the KieContainer to a valid KieModule to fire rules");
			return null;
		}
		
		BatchExecutionCommand batchExecutionCommand = createBatchExecutionCommand(facts, processId, responseClazz);

		RuleListener ruleListener = new RuleListener();

		if (logName != null) {
			KieServices.Factory.get().getLoggers().newFileLogger(session, logName);
		}
		// this is purely for debugging
		else if (debugLogging) {
			session.addEventListener(new DebugRuleRuntimeEventListener());
			session.addEventListener(new DebugAgendaEventListener());
		}
		// this is used capture the enrichments run in the service
		if (this.isRuleListenerActive()) {
			session.addEventListener(ruleListener);
		}

		ExecutionResults results = session.execute(batchExecutionCommand);

		Response response = ReflectiveExecutionResultsTransformer.transform(results, responseClazz);

		// add the listener to the response and delegate the responsibility of
		// setting the enrichments to BusinesRulesAggregationStrategy
		if (responseClazz.equals(KieResponse.class) && this.isRuleListenerActive()) {
			((KieResponse) response).setRuleListener(ruleListener);
		}

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

		return commandFactory.newBatchExecution(commands);
	}

	@Override
	public boolean upgradeRulesToVersion(String group, String artifact, String version) {
		ReleaseId releaseId = KieServices.Factory.get().newReleaseId(group, artifact, version);
		Results results = null;
		try {
			results = kieContainer.updateToVersion(releaseId);
		} catch (UnsupportedOperationException e) {
			LOGGER.info("project started with classpath container, creating new container for" + releaseId.toString());
			try {
				kieContainer = KieServices.Factory.get().newKieContainer(releaseId);
				results = kieContainer.updateToVersion(releaseId);
			} catch (Exception e2) {
				return false;
			}
		}

		return results.getMessages().size() == 0;
	}

	public KieContainer getKieContainer() {
		return kieContainer;
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

	public boolean isRuleListenerActive() {
		return ruleListenerActive;
	}

	public void setRuleListenerActive(boolean ruleListenerActive) {
		this.ruleListenerActive = ruleListenerActive;
	}

	public boolean isDebugLogging() {
		return debugLogging;
	}

	public void setDebugLogging(boolean debugLogging) {
		this.debugLogging = debugLogging;
	}

}
