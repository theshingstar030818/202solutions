package app.config;

import app.parse.ParseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import parse4j.ParseUser;

import javax.servlet.http.HttpSession;

/**
 * Created by tanzeelrana on 3/11/2017.
 */

@ControllerAdvice
@SessionAttributes(value = "currentUser", types = {ParseUser.class})
public class GlobalBindingInitializer {

    @Autowired
    ParseService parseService;

    @ModelAttribute("currentUser")
    ParseUser module(HttpSession session) {

        if(session.getAttribute("currentUser") == null){
            return null;
        }else{
            ParseUser parseUser = ((ParseUser) session.getAttribute("currentUser")).currentUser;
            return parseUser;
        }

    }



    @InitBinder
    public void registerCustomEditors(WebDataBinder binder, WebRequest request) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

}
