package app.parseclient;

import javax.ws.rs.client.Client;

public abstract class ParseClient {

	public static ParseClient create(Client client, String serverURL) {
		return new ParseClientImpl(client.target(serverURL).path("1"));
	}

	public abstract Application application(String applicationId);

}
