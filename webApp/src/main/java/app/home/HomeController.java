package app.home;

import app.parse.ParseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import parse4j.Parse;
import parse4j.ParseUser;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by tanzeelrana on 3/17/2017.
 */
@Controller
public class HomeController {

    @ModelAttribute("module")
    String module() {
        return "home";
    }

    @RequestMapping({"/","/home"})
    String index() {
        if(ParseUser.currentUser != null){
            return "home/homeSignedIn";
        }else{
            return "home/homeNotSignedIn";
        }
    }
}
