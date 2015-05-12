package com.rhc.services.kie;

import org.junit.Assert;
import org.junit.Test;
import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.api.model.ServiceResponse;
import org.kie.server.api.model.ServiceResponse.ResponseType;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;

public class RemoteKieServerTest {

	private static final String HTTP_URL = "http://decisionserver1-jholmes.rhcloud.com/kie-server/services/rest/server";
	private static final String PAYLOAD = "<batch-execution lookup=\"defaultStatelessKieSession\">\n" + "  <insert>\n" + "    <org.kie.example.project1.Foo/>\n" + "  </insert>\n" + "<fire-all-rules/>\n" + "</batch-execution>";

	@Test
	public void test() {
		KieServicesClient client = createDefaultClient();
		Assert.assertNotNull(client);
		System.out.println( PAYLOAD );
		ServiceResponse<String> response = client.executeCommands("test14", PAYLOAD);
		Assert.assertNotNull(response);
		Assert.assertEquals(ResponseType.SUCCESS, response.getType());
		System.out.println( response );
	}

	protected KieServicesClient createDefaultClient() {
		KieServicesConfiguration config = KieServicesFactory.newRestConfiguration(HTTP_URL, null, null);

		config.setMarshallingFormat(MarshallingFormat.JAXB);
		return KieServicesFactory.newKieServicesClient(config);
	}
}
