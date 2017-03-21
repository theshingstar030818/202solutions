package app.parse;

import app.parseclient.*;

import app.parseclient.support.SimpleConfigurations;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 * Created by tanzeelrana on 3/21/2017.
 */

public class ParseService {

    private ParseClient parseClient;
    private Client client;
    private Application application;
    private Perspective perspective;

    public ParseService() {

        client = ClientBuilder.newClient(SimpleConfigurations.jerseyWithJackson());

        parseClient = ParseClient.create(client, "http://162.243.118.87:1339/parse");

        application = parseClient.application("restaurant_app_id").usingMasterKey("restaurant_app_master_key");

        perspective = application.asMaster();

        ObjectResources<ParseObject> gameScores = perspective.withObjects("Order");

        Iterable<ParseObject> parseObjects = gameScores.query().find();
        for (ParseObject parseObject : parseObjects)
            System.out.println(parseObject.getObjectId());


    }

}
