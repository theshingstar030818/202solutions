package app.parse;


import org.springframework.stereotype.Service;
import parse4j.*;
import parse4j.callback.FindCallback;
import parse4j.callback.GetCallback;

import java.util.List;

/**
 * Created by tanzeelrana on 3/21/2017.
 */

@Service
public class ParseService {

    public ParseService() {
        Parse.initializeAsRoot("pace_app_id","pace_app_master_key","http://tanzeelrana.me:1341/parse");
    }

    public List<ParseObject> getAllClients(){
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Patients");
        query.limit(1000);
        try {
            List<ParseObject> clients = query.find();
            return clients;
        }catch (ParseException e){
            return null;
        }
    }
}
