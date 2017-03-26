package app.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import parse4j.ParseException;
import parse4j.ParseUser;

/**
 * Created by tanzeelrana on 3/25/2017.
 */
@Controller
public class SecurityController {

    @RequestMapping({"/logout"})
    String logout() {
        try {
            ParseUser.logout();
        }catch (ParseException e){}
        return "redirect:/";
    }
}
