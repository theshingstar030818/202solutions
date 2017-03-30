package app.parse;


import org.springframework.stereotype.Service;
import parse4j.*;

import java.util.List;

/**
 * Created by tanzeelrana on 3/21/2017.
 */

@Service
public class ParseService {

    public ParseService() {
        Parse.initializeAsRoot("pace_app_id","pace_app_master_key","http://tanzeelrana.me:1341/parse");
    }

    public boolean isAuthenticated(Object parseUser){
        if(parseUser == null){return false;}
        ParseUser currUser =((ParseUser) parseUser);

        System.out.println("current user objectId : " + currUser.getParseObject("pharmacyInfo"));

        return  ( ParseUser.isAuthenticated() );
    }

    public List<ParseObject> getAllClients(ParseUser parseUser){

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Patients");
        query.whereEqualTo("pharmacy", parseUser);
        query.limit(1000);
        try {
            List<ParseObject> clients = query.find();
            return clients;
        }catch (ParseException e){
            return null;
        }
    }

    public ParseObject getPharmacyObject(ParseUser parseUser){
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Pharmacies");
        query.whereEqualTo("pharmacyUser", parseUser);
        try {
            List<ParseObject> clients = query.find();
            return clients.get(0);
        }catch (ParseException e){
            return null;
        }
    }
}
