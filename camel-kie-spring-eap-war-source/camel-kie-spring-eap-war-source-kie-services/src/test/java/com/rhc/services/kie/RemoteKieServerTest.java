package com.rhc.services.kie;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.kie.example.project1.Foo;

public class RemoteKieServerTest {

	private static final String HTTP_URL = "http://decisionserver1-jholmes.rhcloud.com/kie-server/services/rest/server";
	private static final StatelessRemoteKieDecisionService service = new StatelessRemoteKieDecisionService(HTTP_URL, null, null, 0, "test");

	@Test
	public void test() {
		Assert.assertNotNull(service);

		Collection<Object> facts = new ArrayList<Object>();
		facts.add(new Foo("abc"));
		facts.add(new Foo("def"));

		BarResponse response = service.execute(facts, BarResponse.class);

		Assert.assertNotNull(response);
		Assert.assertEquals(2, response.getBars().size());
		System.out.println(response);
	}

}
