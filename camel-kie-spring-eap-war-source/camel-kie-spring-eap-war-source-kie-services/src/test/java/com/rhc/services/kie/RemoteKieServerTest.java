package com.rhc.services.kie;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.kie.example.project1.Foo;
import org.kie.server.api.model.ServiceResponse.ResponseType;

public class RemoteKieServerTest {

	private static final String HTTP_URL = "http://decisionserver1-jholmes.rhcloud.com/kie-server/services/rest/server";
	private static final StatelessRemoteKieDecisionService service = new StatelessRemoteKieDecisionService(HTTP_URL, null, null, 0, "test14");
	
	@Test
	public void test() {
		Assert.assertNotNull(service);

		Collection<Object> facts = new ArrayList<Object>();
		facts.add( new Foo( ) );
		
		String response = service.execute( facts, String.class);

		System.out.println( response );
	}

}
