package app.signin;

import app.signup.SignupForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import parse4j.ParseUser;
import support.web.MessageHelper;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Created by tanzeelrana on 3/25/2017.
 */
@Controller
public class SigninController {

    @ModelAttribute("module")
    String module() {
        return "signin";
    }

    @GetMapping("signin")
    public String signin(Principal principal,  Model model) {

        model.addAttribute(new SigninForm());

        if(ParseUser.currentUser != null){
            return "home/homeSignedIn";
        }else{
            return "signin/signin";
        }
    }

    @RequestMapping(value="/signin", method = RequestMethod.POST)
    String signin(@Valid @ModelAttribute SigninForm signinForm, Errors errors, RedirectAttributes ra) {

        if (errors.hasErrors()) {
            return "/signin/signin";
        }

        MessageHelper.addSuccessAttribute(ra, "signin.success");

        if(ParseUser.currentUser != null){
            return "redirect:/";
        }else{
            try {
                ParseUser.login(signinForm.getUsername(),signinForm.getPassword());
                return "redirect:/";
            }catch (Exception e){
                return "/signin/signin";
            }
        }

    }

}
