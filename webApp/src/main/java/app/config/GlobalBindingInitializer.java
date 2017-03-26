package app.config;

import app.parse.ParseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import parse4j.ParseUser;

/**
 * Created by tanzeelrana on 3/11/2017.
 */

@ControllerAdvice
public class GlobalBindingInitializer {

    @Autowired
    ParseService parseService;

    @ModelAttribute("currentUser")
    ParseUser module() {
        return ParseUser.currentUser;
    }

    @InitBinder
    public void registerCustomEditors(WebDataBinder binder, WebRequest request) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

}
