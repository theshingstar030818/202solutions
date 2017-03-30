package app.signin;

import app.parse.ParseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import parse4j.ParseUser;
import support.web.MessageHelper;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by tanzeelrana on 3/25/2017.
 */
@Controller
public class SigninController {

    @Autowired
    ParseService parseService;

    @ModelAttribute("module")
    String module() {
        return "signin";
    }

    @GetMapping("signin")
    public String signin(HttpSession session,  Model model) {

        model.addAttribute(new SigninForm());

        if(parseService.isAuthenticated(session.getAttribute("currentUser"))){
            return "home/homeSignedIn";
        }else{
            return "signin/signin";
        }
    }

    @RequestMapping(value="/signin", method = RequestMethod.POST)
    String signin(@Valid @ModelAttribute SigninForm signinForm, HttpSession session, Errors errors, RedirectAttributes ra) {

        if (errors.hasErrors()) {
            return "/signin/signin";
        }

        MessageHelper.addSuccessAttribute(ra, "signin.success");

        if(parseService.isAuthenticated(session.getAttribute("currentUser"))){
            return "redirect:/";
        }else{
            try {
                ParseUser parseUser = ParseUser.login(signinForm.getUsername(),signinForm.getPassword());
                session.setAttribute("currentUser", parseUser);
                ParseUser.login("nadir","nadir");
                return "redirect:/";
            }catch (Exception e){
                return "/signin/signin";
            }
        }

    }

}
