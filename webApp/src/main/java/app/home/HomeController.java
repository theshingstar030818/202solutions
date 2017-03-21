package app.home;

import app.parse.ParseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
    String index(Principal principal) {

        ParseService parseService = new ParseService();

        if(principal != null){
            Map<String, String> map = new LinkedHashMap<>();
            map.put("name", principal.getName());
            return "home/homeSignedIn";
        }else{
            return "home/homeNotSignedIn";
        }
    }
}
