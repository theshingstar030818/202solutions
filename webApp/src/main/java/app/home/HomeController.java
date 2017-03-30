package app.home;

import app.parse.ParseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by tanzeelrana on 3/17/2017.
 */
@Controller
public class HomeController {

    @Autowired
    ParseService parseService;

    @ModelAttribute("module")
    String module() {
        return "home";
    }

    @RequestMapping({"/","/home"})
    String index(HttpSession session) {
        if(parseService.isAuthenticated(session.getAttribute("currentUser"))){
            return "home/homeSignedIn";
        }else{
            return "home/homeNotSignedIn";
        }
    }
}
