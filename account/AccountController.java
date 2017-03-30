package app.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import parse4j.ParseUser;

import java.security.Principal;

@RestController
public class AccountController {

    @Autowired
    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("account/current")
    @ResponseStatus(value = HttpStatus.OK)
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public ParseUser currentAccount(Principal principal) {
        Assert.notNull(principal);
        return accountRepository.findOneByEmail(principal.getName());
    }

    @GetMapping("account/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    @Secured("ROLE_ADMIN")
    public ParseUser account(@PathVariable("id") String id) {
        return accountRepository.findOne(id);
    }
}
